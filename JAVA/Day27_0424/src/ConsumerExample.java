/* java.util.function 패키지의   Consumer 계열의 내장 함수형인터페이스 특징)
 *   1.매개값은 있고, 리턴값이 없다.
 */

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerExample {
	public static void main(String[] args) {
		Consumer<String> consumer = t -> System.out.println(t+"21");
		consumer.accept("Java ");
		
		BiConsumer<String,String> bigConsumer = (t,u) -> System.out.println(t+u);
		bigConsumer.accept("Java " , "8");
		
		DoubleConsumer doubleConsumer = value -> System.out.println("Java "+ value);
		doubleConsumer.accept(17.0);
		
		ObjIntConsumer<String> objIntConsumer = (t,value) -> System.out.println(t + value);
		objIntConsumer.accept("Java ", 21);
	}
}