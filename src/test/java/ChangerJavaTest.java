import com.shnaps.DecimalNumbers;
import org.junit.Assert;
import org.junit.Test;

public class ChangerJavaTest {
    @Test
    public final void whenStringIsConvertedFromDecimal() {
        DecimalNumbers testDecimal = new DecimalNumbers("2089685534");
        Assert.assertEquals("два миллиарда восемьдесят девять миллионов шестьсот восемьдесят пять тысяч пятьсот тридцать четыре", testDecimal.numberToString());
        testDecimal.setNumber("8685466");
        Assert.assertEquals("восемь миллионов шестьсот восемьдесят пять тысяч четыреста шестьдесят шесть", testDecimal.numberToString());
        testDecimal.setNumber("0");
        Assert.assertEquals("ноль", testDecimal.numberToString());
        testDecimal.setNumber("235678945623056685");
        Assert.assertEquals("двести тридцать пять квадриллионов шестьсот семьдесят восемь триллионов девятьсот сорок пять миллиардов шестьсот двадцать три миллиона пятьдесят шесть тысяч шестьсот восемьдесят пять",
                testDecimal.numberToString());
        testDecimal.setNumber("-235678945623056685");
        Assert.assertEquals("минус двести тридцать пять квадриллионов шестьсот семьдесят восемь триллионов девятьсот сорок пять миллиардов шестьсот двадцать три миллиона пятьдесят шесть тысяч шестьсот восемьдесят пять",
                testDecimal.numberToString());

    }
}
