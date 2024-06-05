package org.example;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private int score;
    private boolean lastFrame;
    private IGenerateur generateur;
    private List<Roll> rolls;

    public Frame() {
    }

    public Frame(IGenerateur generateur, boolean lastFrame) {
        this.lastFrame = lastFrame;
        this.generateur = generateur;
        this.rolls = new ArrayList<>();
        this.score = 0;
    }

    public boolean makeRoll(){
        if (lastFrame) {
            if (rolls.size() < 2) {
                rolls.add(new Roll(10));
                score += 10;
                return true;
            } else if (rolls.size() == 2) {
                if (rolls.get(0).getPins() == 10 || (rolls.get(0).getPins() + rolls.get(1).getPins() == 10)) {
                    rolls.add(new Roll(10));
                    score += 10;
                    return true;
                }
            }
            return false;
        } else {
            if (rolls.size() == 0 || (rolls.size() == 1 && rolls.get(0).getPins() < 10)) {
                rolls.add(new Roll(10));
                score += 10;
                return true;
            }
            return false;
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isLastFrame() {
        return lastFrame;
    }

    public void setLastFrame(boolean lastFrame) {
        this.lastFrame = lastFrame;
    }

    public IGenerateur getGenerateur() {
        return generateur;
    }

    public void setGenerateur(IGenerateur generateur) {
        this.generateur = generateur;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }


}
