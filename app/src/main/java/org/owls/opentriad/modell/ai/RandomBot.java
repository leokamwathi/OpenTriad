package org.owls.opentriad.modell.ai;

import org.owls.opentriad.OpenTriad;
import org.owls.opentriad.modell.Competitor;
import org.owls.opentriad.modell.Deck;
import org.owls.opentriad.ui.customviews.DeckView;

import java.util.Random;

/**
 * @author Benjamin Wulfert (wulfert.benjamin@googlemail.com)
 * @version 0.1a
 *
 * The Bot-class is a regular Competitor with additional functionality added to simulate
 * the turns of a "real player". This _really_ simple implementation relies on Random cards which are
 * set on a random position on the BattleField.
 */
public class RandomBot extends Competitor {

    private Random random;

    public RandomBot(String name, Deck deck) {
        super(name, deck);

        this.isBot = true;

        random = new Random(System.currentTimeMillis());
    }

    public void computeActiveCard(DeckView opponentDeck) {
        opponentDeck.setActiveCard(random.nextInt(deck.size()));
    }

    public int[] computeCardPosition() {
        return new int[]{random.nextInt(OpenTriad.BATTLEFIELD_MAX_ROW), random.nextInt(OpenTriad.BATTLEFIELD_MAX_COLUMN)};
    }

}

