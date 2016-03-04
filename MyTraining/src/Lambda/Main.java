package Lambda;

//Лямбда вираз - це анонімний метод, який реалізує абстрактний метод з функціональернр інтерфейсу
//Абстрактний інтерфейс  - інтерфейс в якого тільки один абстрактний метод 

public class Main {

	public static void main(String[] args) {
		//Силка на функціональний інтерфейс
		MyNumber myNumber;
		NumericTest isEven;
		
		//Простий приклад коли силоцній змінній присвоюється значення
		//створюється екземпляр класа, в якому лямбда-вирази реалізують метод getValue() 
		//із функціонального інтерфейсу
		myNumber = () -> 129.45;
		System.out.println(myNumber.getValue());
		
		myNumber = () -> Math.random() * 100;
		System.out.println(myNumber.getValue());
		
		//Лямбда враз повинен бути сцмісний по типу з абстрактним методом 
		// myNumber = () -> "dfdf";  -  Помилка
		
		//Перевіряємо число на парність
		//Створюється об'єкт в якого метод test() буде перевіряти чи число ділиться на 2 і в залежності
		//від результату буде вертати true або false
		isEven = (n) -> (n % 2) == 0;
		if(isEven.test(13)){
			System.out.println("Число парне");
		}else{
			System.out.println("число не парне");
		}
		
		//Перевіряємо число на відємне
		isEven = (n) -> n >= 0;
		if(isEven.test(3)){
			System.out.println("додатнє");
		}else{
			System.out.println("відємне");
		}
		
		//Факторіал числа
		//Приклад блочного лямбда-виразу
		NumericTest2 factorial;
		
		factorial = (n) -> {
			int result = 1;
			for(int i=1; i<=n; i++){
				result = i*result;
			}
			return result;
		};
		System.out.println(factorial.test(5));
		
		//Приклад з Generic інтерфейсом
		//Даний інтерфейс використовується в двох прикладах що зменшує кількість коду
		//Приклад повертає стрічку у зворотньому порядку
		SomeFunc<String> reverse = (str) -> {
			String result  = "";
			int i;
			for(i = str.length()-1; i>=0;i--){
				result+=str.charAt(i);
			}
			return result;
		};
		System.out.println(reverse.func("Бистров"));
		SomeFunc<Integer> fact = (n) ->{
			int result = 1;
			for(int i = 1; i<=n; i++){
				result *= i;
			}
			return result;
		};
		System.out.println(fact.func(3));
		
		
	}

}
