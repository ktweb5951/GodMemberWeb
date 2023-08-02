package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/member/update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw  = request.getParameter("member-pw");
		String memberGender = request.getParameter("member-gender");
		String memberEmail  = request.getParameter("member-email");
		String memberPhone  = request.getParameter("member-phone");
		String memberAddress  = request.getParameter("member-address");
		String memberHobby  = request.getParameter("member-hobby");
		
		//UPDATE MEMBER_TBL SET MEMBER_PW =? , MEMBER_EMAIL = ? , MEMBER_PHONE = ?, MEMBER_ADDRESS =?, MEMBER_HOBBY=?, UPDATE_DATE =DEFAULT WHERE MEMBER_ID
		MemberService service = new MemberService();
//		Member member = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddress, memberHobby);
//		int result = service.updateMember(memberId, memberPw, memberEmail, memberPhone, memberAddress, memberHobby);
		Member member= new Member(memberId, memberPw, memberGender, memberEmail, memberPhone, memberAddress, memberHobby);
		int result = service.updateMember(member);
		if(result>0) {
			//성공하면 메인페이지
//			request.setAttribute("msg", "회원정보 수정 완료");
//			request.setAttribute("url", "/index.jsp");
//			RequestDispatcher view = request.getRequestDispatcher("/member/serviceSuccess.jsp");
//			view.forward(request, response);	
			response.sendRedirect("/index.jsp");
		} else {
			//실패하면 에러페이지
			request.setAttribute("msg", "회원정보 수정이 완료되지 않았습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/common/serviceFailed.jsp");
			view.forward(request, response);	
		}
	}

}
