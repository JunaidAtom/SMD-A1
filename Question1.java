public class Main {

    interface Cricketer {
        void print();
    }

    static class BaseCricketer implements Cricketer {
        protected String name;
        protected int age;
        protected String nationality;

        public BaseCricketer(String name, int age, String nationality) {
            this.name = name;
            this.age = age;
            this.nationality = nationality;
        }

        public void print() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("\nNationality: " + nationality);
        }
    }

    interface Batsman extends Cricketer {
        void getRanking();
    }

    interface Bowler extends Cricketer {
        void getRanking();
    }

    static class BaseBatsman extends BaseCricketer implements Batsman {
        protected int score;
        protected int batsmanRanking;

        public BaseBatsman(String name, int age, String nationality, int score, int batsmanRanking) {
            super(name, age, nationality);
            this.score = score;
            this.batsmanRanking = batsmanRanking;
        }

        public void print() {
            super.print();
            System.out.println("Batsman Score: " + score);
            System.out.println("Batsman Ranking: " + batsmanRanking);
        }

        public void getRanking() {
            System.out.println("Batsman Ranking: " + batsmanRanking);
        }
    }

    static class BaseBowler extends BaseCricketer implements Bowler {
        protected int wickets;
        protected int bowlerRanking;

        public BaseBowler(String name, int age, String nationality, int wickets, int bowlerRanking) {
            super(name, age, nationality);
            this.wickets = wickets;
            this.bowlerRanking = bowlerRanking;
        }

        public void print() {
            super.print();
            System.out.println("Total wickets: " + wickets);
            System.out.println("Bowler Ranking: " + bowlerRanking);
        }

        public void getRanking() {
            System.out.println("Bowler Ranking: " + bowlerRanking);
        }
    }

    interface AllRounder extends Batsman, Bowler {
        void getAllRounderRanking();
    }

    static class BaseAllRounder extends BaseBatsman implements AllRounder {
        protected int allRounderRanking;

        public BaseAllRounder(String name, int age, String nationality, int score, int batsmanRanking, int allRounderRanking) {
            super(name, age, nationality, score, batsmanRanking);
            this.allRounderRanking = allRounderRanking;
        }

        public void print() {
            super.print();
            System.out.println("All-Rounder Ranking: " + allRounderRanking);
        }

        public void getRanking() {
            System.out.println("All-Rounder Ranking: " + allRounderRanking);
        }

        public void getAllRounderRanking() {
            System.out.println("All-Rounder Ranking: " + allRounderRanking);
        }
    }

    public static void main(String[] args) {
        Cricketer cricketer = new BaseCricketer("Junaid", 21, "Pakistani");
        Batsman batsman = new BaseBatsman("Muaaz", 18, "Pakistani", 1000, 1);
        Bowler bowler = new BaseBowler("Virat Kohli", 28, "Indian", 200, 3);
        AllRounder allRounder = new BaseAllRounder("Ab DeVilliers", 27, "South African", 800, 2, 2);

        cricketer.print();
        System.out.println();
        batsman.print();
        System.out.println();
        bowler.print();
        System.out.println();
        allRounder.print();
    }
}