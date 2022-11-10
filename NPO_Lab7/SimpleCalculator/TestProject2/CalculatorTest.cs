using SimpleCalculator;
using NUnit.Framework;

namespace SimpleCalculatorTests
{
    public class CalculatorTest
    {
        [Test]
        public void Add_ShouldBeEqualTo_ManualAddition()
        {
            var number1 = 1.1412355620;
            var number2 = 0.3;
            var excpectedAddition = Math.Round(number1 + number2, 3);
            var actualAddition = Calculator.Add(number1, number2);
            Assert.That(actualAddition, Is.EqualTo(excpectedAddition));
        }

        [Test]
        public void Substract_ShouldBeEqualTo_ManualSubstraction()
        {
            var number1 = -332432;
            var number2 = 0.000007;
            var excpectedSubstraction = Math.Round(number1 - number2, 3);
            var actualSubstraction = Calculator.Substract(number1, number2);
            Assert.That(actualSubstraction, Is.EqualTo(excpectedSubstraction));
        }

        [Test]
        public void Multiply_ShouldBeEqualTo_ManualMultiplication()
        {
            var number1 = 5656;
            var number2 = 0.11333333;
            var excpectedMultiplication = Math.Round(number1 * number2, 3);
            var actualMultiplication = Calculator.Multiply(number1, number2);
            Assert.That(actualMultiplication, Is.EqualTo(excpectedMultiplication));
        }

        [Test]
        public void Divide_ShouldBeEqualTo_ManualDivision()
        {
            var number1 = 14560;
            var number2 = 0.456343333;
            var excpectedDivision = Math.Round(number1 / number2, 3);
            var actualDivision = Calculator.Divide(number1, number2);
            Assert.That(actualDivision, Is.EqualTo(excpectedDivision));
        }

        [Test]
        public void ExtractTheSquareRoot_ShouldBeEqualTo_ManualSquareRootExtraction()
        {
            var number = 123.816212435634634634;
            var expectedSquareRoot = Math.Round(Math.Sqrt(number), 3);
            var actualSquareRoot = Calculator.ExtractSquareRoot(number);
            Assert.That(actualSquareRoot, Is.EqualTo(expectedSquareRoot));
        }

        [Test]
        public void ExtractRoot_ShouldBeEqualTo_ManualRootExtraction()
        {
            var number = 81873287832;
            var power = 124124;
            var expectedRoot = Math.Round(Math.Pow(number, 1 / power), 3);
            var actualRoot = Calculator.ExtractRoot(number, power);
            Assert.That(actualRoot, Is.EqualTo(expectedRoot));
        }

        [Test]
        public void RaiseToThePower_ShouldBeEqualTo_ManualExponentiation()
        {
            var number = 312383;
            var power = 12442;
            var expectedNumberRaisedToThePower = Math.Round(Math.Pow(number, power), 3);
            var actualNumberRaisedToThePower = Calculator.RaiseToThePower(number, power);
            Assert.That(actualNumberRaisedToThePower, Is.EqualTo(expectedNumberRaisedToThePower));
        }

        [Test]
        public void ExtractRoot_ShouldBeEqualTo_ExtractSquareRoot_WhenPowerEqualsTwo()
        {
            var number = 256;
            var power = 2;
            var rootOfTheSecondDegree = Calculator.ExtractRoot(number, power);
            var squareRoot = Calculator.ExtractSquareRoot(number);
            Assert.That(squareRoot, Is.EqualTo(rootOfTheSecondDegree));
        }

        [Test]
        public void RaiseToThePower_ShouldBeEqualTo_One_WhenPowerEqualsZero()
        {
            var number = 81812837;
            var power = 0;
            var numberRaisedToPower = Calculator.RaiseToThePower(number, power);
            Assert.That(numberRaisedToPower, Is.EqualTo(1));
        }

        [Test]
        public void RaiseToThePower_ShouldBeEqualTo_ExtractRoot_WhenPowerIsLessThanOneAndMoreThanZero()
        {
            var number = 8;
            var power = 0.5;
            var rootOfNumber = Calculator.ExtractRoot(number, 1 / power);
            var numberRaisedToPower = Calculator.RaiseToThePower(number, power);
            Assert.That(rootOfNumber, Is.EqualTo(numberRaisedToPower));
        }

        [Test]
        public void RaiseToThePower_ShouldBeEqualTo_TheInverseNumberRaisedToPower_WhenPowerIsLessThanZero()
        {
            var number = 2;
            var power = -3;
            var numberInversed = 1 / Calculator.RaiseToThePower(number, power * -1);
            var numberRaisedToPower = Calculator.RaiseToThePower(number, power);
            Assert.That(numberInversed, Is.EqualTo(numberRaisedToPower));
        }
    }
}