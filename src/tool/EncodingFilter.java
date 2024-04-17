package tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@Webfilterでフィルターを適用するURLを指定する
@WebFilter(urlPatterns={"/*"})
public class EncodingFilter implements Filter {

	public void doFilter(
		ServletRequest request, ServletResponse response,
		FilterChain chain
	) throws IOException, ServletException {
		//フィルター内に共通の処理を記述する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		//エクリプスのコンソールに文字列を出力する
		System.out.println("フィルタの前処理");
		chain.doFilter(request, response);
		System.out.println("フィルタの後処理");
	}

	public void init(FilterConfig filterConfig) {}
	public void destroy() {}
}
