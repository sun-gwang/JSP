package sub3;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionListener implements HttpSessionAttributeListener{
	
	int count = 0;
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// 세션에 추가될때 호출되는 메서드(setAttribute)
		count++;
		System.out.println("arrributeAdded... ");
		
		System.out.println("현재 로그인 중인 사용자 : " + count);
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// 세션이 해제될 때 호출되는 메서드(invalidate)
		System.out.println("arrributeAdded... ");
		
		count--;
		System.out.println("현재 로그인 중인 사용자 : " + count);
	}
}
