import org.junit.Assert;
import org.junit.Test;

public class SimpleTests {

    // Тестируем ИМТ

    @Test
    public void test_CriticalUnderWeight_WhereHeightIs100_AndWeightIs1() {
        var actualResult = getIMTResult(100f, 1f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void test_CriticalUnderWeight_WhereHeightIs216_AndWeightIs75() {
        var actualResult = getIMTResult(216f, 75f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void test_CriticalUnderWeight_WhereHeightIs350_AndWeightIs75() {
        var actualResult = getIMTResult(350f, 75f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void test_CriticalUnderWeight_WhereHeightIs349_AndWeightIs75() {
        var actualResult = getIMTResult(349f, 75f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void test_UnderWeight_WhereHeightIs210_AndWeightIs75() {
        var actualResult = getIMTResult(210f, 75f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }

    @Test
    public void test_UnderWeight_WhereHeightIs203_AndWeightIs75() {
        var actualResult = getIMTResult(203f, 75f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }

    @Test
    public void test_NormalWeight_WhereHeightIs198_AndWeightIs75() {
        var actualResult = getIMTResult(198f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void test_NormalWeight_WhereHeightIs193_AndWeightIs75() {
        var actualResult = getIMTResult(193f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void test_NormalWeight_WhereHeightIs184_AndWeightIs75() {
        var actualResult = getIMTResult(184f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void test_NormalWeight_WhereHeightIs180_AndWeightIs75() {
        var actualResult = getIMTResult(180f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void test_NormalWeight_WhereHeightIs177_AndWeightIs75() {
        var actualResult = getIMTResult(177f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void test_OverWeight_WhereHeightIs173_AndWeightIs75() {
        var actualResult = getIMTResult(173f, 75f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void test_OverWeight_WhereHeightIs113_AndWeightIs75() {
        var actualResult = getIMTResult(113f, 75f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void test_OverWeight_WhereHeightIs27_AndWeightIs75() {
        var actualResult = getIMTResult(27f, 75f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void test_OverWeight_WhereHeightIs300_AndWeightIs999() {
        var actualResult = getIMTResult(300f, 999f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void test_OverWeight_WhereHeightIs300_AndWeightIs1000() {
        var actualResult = getIMTResult(300f, 1000f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void test_OverWeight_WhereHeightIs1_AndWeightIs75() {
        var actualResult = getIMTResult(1f, 75f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void test_IncorrectWeight_WhereHeightIs1_AndWeightIs0() {
        var actualResult = getIMTResult(1f, 0f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void test_IncorrectWeight_WhereHeightIs1_AndWeightIsMinus1() {
        var actualResult = getIMTResult(1f, -1f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void test_IncorrectWeight_WhereHeightIs3_AndWeightIs1001() {
        var actualResult = getIMTResult(1f, 0f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void test_IncorrectHeight_WhereHeightIsMinus1_AndWeightIs75() {
        var actualResult = getIMTResult(-1f, 75f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void test_IncorrectHeight_WhereHeightIs351_AndWeightIs75() {
        var actualResult = getIMTResult(351f, 75f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void test_IncorrectHeight_WhereHeightIs0_AndWeightIs75() {
        var actualResult = getIMTResult(0f, 75f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }


    private String getIMTResult(Float heightCm, Float weightKg)
    {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;
        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19)  {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        if (heightCm.equals(0.0f)) userResult+="указан некорректный рост";
        return userResult;
    }

    //Тестируем функцию перевода баллов по школьному экзамену в оценки

    @Test
    public void Should_BeMark2_When_ScoreIs0() {
        var actualResult = getMarkResult(0);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void Should_BeMark2_When_ScoreIs1() {
        var actualResult = getMarkResult(1);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void Should_BeMark2_When_ScoreIs34() {
        var actualResult = getMarkResult(34);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void Should_BeMark2_When_ScoreIs35() {
        var actualResult = getMarkResult(35);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void Should_BeMark3_When_ScoreIs36() {
        var actualResult = getMarkResult(36);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void Should_BeMark3_When_ScoreIs37() {
        var actualResult = getMarkResult(37);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void Should_BeMark3_When_ScoreIs55() {
        var actualResult = getMarkResult(55);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void Should_BeMark3_When_ScoreIs56() {
        var actualResult = getMarkResult(56);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void Should_BeMark4_When_ScoreIs57() {
        var actualResult = getMarkResult(57);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void Should_BeMark4_When_ScoreIs58() {
        var actualResult = getMarkResult(58);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void Should_BeMark4_When_ScoreIs70() {
        var actualResult = getMarkResult(70);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void Should_BeMark4_When_ScoreIs71() {
        var actualResult = getMarkResult(71);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void Should_BeMark5_When_ScoreIs72() {
        var actualResult = getMarkResult(72);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void Should_BeMark5_When_ScoreIs73() {
        var actualResult = getMarkResult(73);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void Should_BeMark5_When_ScoreIs99() {
        var actualResult = getMarkResult(99);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void Should_BeMark5_When_ScoreIs100() {
        var actualResult = getMarkResult(100);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void Should_BeNoMarkResult_When_ScoreIsMunis1() {
        var actualResult = getMarkResult(-1);
        Assert.assertEquals("no mark result", actualResult);
    }

    @Test
    public void Should_BeNoMarkResult_When_ScoreIs101() {
        var actualResult = getMarkResult(101);
        Assert.assertEquals("no mark result", actualResult);
    }

    private String getMarkResult(Integer mark)
    {
        if(mark>=0 && mark <=35) return "2";
        if(mark>35 && mark <=56) return "3";
        if(mark>56 && mark<71) return "4";
        if(mark>72 && mark<100) return "5";
        return "no mark result";
    }
//    Примеры для разных стилей:
//#1 getMarkResult_ScoreIs100_ResultIs5
//#3 testResultIs4IfScoreMoreThan60AndLessThan80
//#5 Should_BeMark2_When_ScoreIs0
//   Should_ReturnMark3_When_ScoreMoreThan60AndLessThan80
}
