package sort;


import edu.neu.coe.info6205.sort.DualPivotQuickSort;
import org.junit.Test;


import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Sandeep Barla
 */
public class DualPivotQuickSortTest {

    @Test
    public void sortHindi0() {
        String[] expected = new String[]{"असर","उसका","और","करने","करने","का","कार्य","की","के","क्षमता","खाते","खाना","ज़िन्दगी","जैसा","पड़ता","पर","भोजन","भोजन","मन","मस्तिष्क","महत्वपूर्ण","मिलती","में","सभी","से"};
        String[] input = Arrays.copyOf(expected,expected.length);
        Collections.shuffle(Arrays.asList(input));
        new DualPivotQuickSort().sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortHindi1() {
        String[] expected = new String[]{"अन्न","ईश्वर","के","के","को","जाता","धर्म","ब्रह्म","भगवान्","भोजन","माना","मुताबिक","में","रूप","शास्त्रों","सनातन","समान","है"};
        String[] input = Arrays.copyOf(expected,expected.length);
        Collections.shuffle(Arrays.asList(input));
        new DualPivotQuickSort().sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortHindi2() {
        String[] expected = new String[]{"उसका","करते","करते","का","का","चरित्र","ज़्यादा","जैसा","थे","पड़ता","पर","पहले","प्रभाव","भी","भोजन","लोग","सेवन","हम","हमारे","है"};
        String[] input = Arrays.copyOf(expected,expected.length);
        Collections.shuffle(Arrays.asList(input));
        new DualPivotQuickSort().sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void sortHindi3() {
        String[] expected = new String[]{"का","किया","कीटनाशक","के","के","ज़्यादा","जाता","तब","था","था","थी","दवाईयों","नहीं","नहीं","पैदावार","प्रदूषण","प्रयोग","फसलों","मिलावट","रासायनिक","लिए","होती"};
        String[] input = Arrays.copyOf(expected,expected.length);
        Collections.shuffle(Arrays.asList(input));
        new DualPivotQuickSort().sort(input);
        assertArrayEquals(expected, input);
    }

}
