package tripmn;

import com.tripmn.repository.UserRepository;

public class SpringRepoServiceTest {

	private UserRepository repository;
	
	public void test(){
		repository.findById(1L, true);
	}
}
