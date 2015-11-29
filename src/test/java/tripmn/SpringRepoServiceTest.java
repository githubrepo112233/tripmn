package tripmn;

import java.util.Date;

import com.tripmn.repository.UserRepository;
import com.tripmn.utils.PlatformUtils;

public class SpringRepoServiceTest {

	private UserRepository repository;
	
	public void test(){
		repository.findById(1L, true);
	}
	
	public static void main(String a[]){
		System.out.println(PlatformUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
	}
}
