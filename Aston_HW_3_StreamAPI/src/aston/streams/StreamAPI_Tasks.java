package aston.streams;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI_Tasks {

	public static void main(String[] args) {
		 // Создаем список целых чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // фильтрация четных чисел и их сортировка
        List<Integer> sortedEvens = numbers.stream() //  список в поток
                .filter(n -> n % 2 == 0) // фильтруем потока
                .sorted() // сортируем по возрастанию
                .collect(Collectors.toList()); //  результат в новый список

        // Выводим отсортированный список четных чисел
        System.out.println("Четные числа, отсортированные по возрастанию: " + sortedEvens);
    
        // Создаем список строк
        List<String> strings = Arrays.asList( "API", "java", "hello world", "Stream", "Пример например");

        //  преобразования каждой строки в верхний регистр
        List<String> upperCaseStrings = strings.stream() //  список в поток
                .map(String::toUpperCase) // в верхний регистр
                .collect(Collectors.toList()); // результат в новый список

        // Выводим преобразованный список строк
        System.out.println("Строки в верхнем регистре: " + upperCaseStrings);
        
        int[] arrNumbers = {1, 2, 3, 4, 5};
        int summ = Arrays.stream(arrNumbers)
        		.sum();
        System.out.println("Сумма элементов массива: " + summ);
        
        Optional<String> firstLongString = strings.stream() // преобразуем список в поток
                .filter(s -> s.length() > 5) // фильтруем поток, оставляя строки длиннее 5 символов
                .findFirst(); // находим первое вхождение в потоке после фильтрации

            // Выводим результат, если такая строка существует
            if (firstLongString.isPresent()) {
                System.out.println("Первая строка длиной более 5 символов: " + firstLongString.get());
            // Выводим результат, если такая строка не существует
            } else {
                System.out.println("Строка, удовлетворяющая условию, не найдена.");

	}
         //  параллельный Stream API для фильтрации и поиска первой строки длиной более 5 символов
            Optional<String> firstLongString2 = strings.parallelStream() // преобразуем список в параллельный поток
                .filter(s -> s.length() > 5) // фильтруем поток, оставляя строки длиннее 5 символов
                .findFirst(); // находим первое вхождение в потоке после фильтрации

            // Выводим результат, если такая строка существует
            if (firstLongString.isPresent()) {
                System.out.println("Первая строка длиной более 5 символов: " + firstLongString2.get());
            // Выводим результат, если такая строка существует    
            } else {
                System.out.println("Строка, удовлетворяющая условию, не найдена.");
            }
            
            List<String> newStrings = Arrays.asList("123", "456", "hello", "789", "world", "101112");

            // Создаем функцию, которая пытается преобразовать строку в целое число и возвращает Optional<Integer>
            Function<String, Optional<Integer>> safeParseInt = str -> {
                try {
                    return Optional.of(Integer.parseInt(str));
                } catch (NumberFormatException e) {
                    return Optional.empty();
                }
            };

            // Используем Stream API для фильтрации и обработки элементов, преобразовывая их в Optional<Integer>
            List<Integer> validNumbers = newStrings.stream()
                // Преобразуем каждую строку в Optional<Integer>, который может быть пустым, если строка не является числом
                .map(safeParseInt)
                // Используем flatMap для преобразования Stream<Optional<Integer>> в Stream<Integer> с исключением пустых значений
                .flatMap(Optional::stream)
                // Собираем результат в список
                .collect(Collectors.toList());

            // Выводим отфильтрованный список чисел
            System.out.println("Отфильтрованный список корректных чисел: " + validNumbers);
            
	}

}
