namespace SimpleCalculator
{
    public class Calculator
    {
        public static double Add(double number1, double number2) => RoundNumber(number1 + number2);

        public static double Substract(double number1, double number2) => RoundNumber(number1 - number2);

        public static double Multiply(double number1, double number2) => RoundNumber(number1 * number2);

        public static double Divide(double number1, double number2) => RoundNumber(number1 / number2);

        public static double ExtractTheRoot(double number, double power) => RoundNumber(Math.Pow(number, 1 / power));

        public static double ExtractTheSquareRoot(double number1) => RoundNumber(Math.Sqrt(number1));

        public static double RaiseToThePower(double number, double power)
        {
            if (number % 1 == 0)
            {
                var initialNumber = number;
                for (int i = 1; i <= power; i++)
                {

                }
            }

            return RoundNumber(Math.Pow(number, power));
        }

        private static double RoundNumber(double operationResult) => Math.Round(operationResult, 3);
    }
}
