import use_case.signup.SignupOutputBoundary;

import java.util.Iterator;
import java.util.NoSuchElementException;

// TODO: Task 1 make Week iterable
public class Week implements Iterable<String>{
    private final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String getDay(int i) {
        return days[i];
    }

    /**
     * Sample usage of the Week class. See WeekTest.java for the tests.
     */
    public static void main(String[] args) {
        Week week = new Week();

//        for (int i = 0; i != 7; i++) {
//            System.out.println(week.getDay(i));
//        }
        for (String day : week) {
            System.out.println(day);
        }
    }

    @Override
    public Iterator<String> iterator() {

            return new WeekIterator();
        }
    class WeekIterator implements Iterator<String>{
        private int currIndex;

        public WeekIterator(){
            currIndex = 0;
        }
        @Override
        public boolean hasNext() {
            if (currIndex == 7){
                return false;
            }
            else {
                return true;
            }
        }

        @Override
        public String next() throws NoSuchElementException {
            if (this.hasNext()) {
                int oldIndex = currIndex;
                currIndex++;
                return days[oldIndex];
            }
            else{
                throw new NoSuchElementException();
            }
        }
    }
}