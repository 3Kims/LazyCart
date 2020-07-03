package servlet.controller.workers;
/*
 * 결과페이지 이름과
 * 이동방식(forward | redirect)에 대한 정보를 담고 있는 객체
 * ModelAndView  Model은 객체도 담을 수 있게... 라이브러리에서 이름을 따왔음. 
 */
public class ModelAndView {
	
	private String path;
	private boolean isRedirect;   //필드의 타입이 boolean일때 이렇게 활용하면 좋다. 생성자도 저렇게 만들면 편하다.
	
	public ModelAndView() {
		super();
	}

	public ModelAndView(String path) {
		this.path = path;
	}
	
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
