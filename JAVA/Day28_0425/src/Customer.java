import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Customer implements Externalizable {//객체 직렬화를 위한 클래스 설계

	int id;
	String name;
	int age;
	double height;
	
	public Customer() {}
	
	public Customer(int id,String name,int age,double height) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.height=height;
	}//생성자 오버로딩
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(id);//기본타입이 래퍼 참조타입으로 자동형변환(자바5버전에서 추가된 오토박싱)하고 부모타입으로 업캐스팅해서
		//저장
		out.writeObject(name);//업캐스팅하면서 저장
		out.writeObject(age);//오토박싱+업캐스팅
		out.writeObject(height);//오토박싱과업캐스팅
	}//객체 단위로 기록
	

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = (Integer)in.readObject();//명시적인 다운캐스팅+오토언박싱(자바5에서 추가된 래퍼참조타입이 기본타입으로 형변환)
		name = (String)in.readObject();//명시적인 다운캐스팅
		age = (Integer)in.readObject();//다운캐스팅+오토언박싱
		height = (Double)in.readObject();//다운캐스팅과 오토언박싱
	}//객체 단위로 읽어오기

	@Override
	public String toString() {
		return "id="+id+", name="+name+", age="+age+", height="+height;
	}	
}
