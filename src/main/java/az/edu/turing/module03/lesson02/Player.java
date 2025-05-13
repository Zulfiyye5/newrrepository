package az.edu.turing.module03.lesson02;

public class Player implements Comparable<Player> {
    public String name;
    public int score;

    public Player(String name,int score){
        this.name = name;
        this.score = score;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;

    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Player other) {
        return this.score- other.score;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
