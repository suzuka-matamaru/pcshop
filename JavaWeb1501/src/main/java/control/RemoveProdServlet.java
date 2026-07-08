package control;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Operation;

/**
 * Servlet implementation class RemoveProdServlet
 */
@WebServlet("/remove-prod-servlet")
public class RemoveProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//パラメータ取得
		request.setCharacterEncoding("UTF-8");
		int idx =Integer.parseInt(request.getParameter("idx"));
		
		//セッションオブジェクト取得
		HttpSession session = request.getSession();
		
		//カートへの商品削除処理
		Operation op = new Operation();
		op.removeProd(idx,session);
		
		//転送先設定
		String url ="cart.jsp";
		
		//転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

		
	}

}
