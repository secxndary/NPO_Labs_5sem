namespace SimpleCalculator
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine($"0,2 + 0,1 = {Calculator.Add(0.2, 0.1)}");
            Console.WriteLine($"1 - 0,7 = {Calculator.Substract(1, 0.7)}");
            Console.WriteLine($"6 * 0,3 = {Calculator.Multiply(6, 0.3)}");
            Console.WriteLine($"10 / 0,3 = {Calculator.Divide(10, 0.3)}");
            Console.WriteLine($"2 ^ -1 = {Calculator.RaiseToThePower(2, -1)}");
            Console.WriteLine($"5 ^ 0 = {Calculator.RaiseToThePower(5, 0)}");
            Console.WriteLine($"4 ^ 3 = {Calculator.RaiseToThePower(4, 3)}");
            Console.WriteLine($"2 ^ 0,5 = {Calculator.RaiseToThePower(2, 0.5)}");
            Console.WriteLine($"64 root 3 = {Calculator.ExtractRoot(64, 3)}");
            Console.WriteLine($"81 root 2 = {Calculator.ExtractSquareRoot(81)}");
        }
    }
}