package problems;

public class PetRock {
    private String name;
    private boolean happy = false;

    public PetRock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public boolean isHappy() {
        return happy;
    }

    public void play() {
        happy = true;
    }

    public String getHappyMessage(){
        if(!happy){
            throw new IllegalStateException();
        }
        return "I'm Happy!";
    }
}
