
package com.gs.dsa.students;
import org.junit.jupiter.api.Test;import static org.assertj.core.api.Assertions.*;import java.util.*;
public class BestAveragePerStudentTest {
//  @Test void validation(){ String[][] data={{"Alice","90"},{"Alice","10"},{"Bob","70"},{"Bob","80"},{"Bob","50"}};
//      Map<String,Double> m=BestAveragePerStudent.bestAverages(data);
//      assertThat(m.get("Alice")).isEqualTo(50.0);
//      assertThat(m.get("Bob")).isEqualTo(66.00);
//  }
    @Test void validation1(){
      String[][] data={{"Alice",String.valueOf(Integer.MAX_VALUE)},{"Alice","10"},
            {"Bob","70"},{"Bob","80"},{"Bob","50"}};
        String[][] data1={{"Alice",String.valueOf(Integer.MIN_VALUE)},{"Alice","10"},
                {"Bob","70"},{"Bob","80"},{"Charles","50"}};
        //Map<String,Double> m=BestAveragePerStudent.bestAverages(data);
        assertThat(BestAveragePerStudent.bestAverages(data)).isEqualTo("Alice");
        assertThat(BestAveragePerStudent.bestAverages(data1)).isEqualTo("Bob");
    }
}
