package org.share0u.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.tomcat.util.collections.SynchronizedStack;
import org.share0u.domain.MemberVO;
import org.share0u.domain.RecordVO;
import org.share0u.util.DBExecutor;


public class Share0uDAO 
{
	static boolean status = false;
	static Integer count = 0;

	//�α���
	public static boolean memberLogin(MemberVO vo)
	{		
		status = false;
		new DBExecutor((con,pstmt,rs) -> {
			pstmt = con.prepareStatement("select mid, mpw,mname,mrole from tbl_member where mid=? and mpw=?");
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				status = true;
			}
		}).execute();
		return status;
	}
	
	public static MemberVO memberValue(MemberVO vo)
	{
		
		new DBExecutor((con,pstmt,rs) -> {
			pstmt = con.prepareStatement("select mid, mpw,mname,mrole from tbl_member where mid=? and mpw=?");
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				vo.setMname(rs.getString(3));
				vo.setMrole(rs.getString(4));
			}
		}).execute();
		return vo;
	}
	
	
	
	//ȸ������	
	public static void memberInsert(MemberVO vo) throws Exception{

		new DBExecutor((con,pstmt,rs) -> {
			pstmt = con.prepareStatement("insert  into tbl_member (mid ,mpw, mname, mrole) "
					+ "values(?,?,?,?)");
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMrole());
			rs = pstmt.executeQuery();
		}).execute();
	}
	
	
	public static List<RecordVO> noticeRead()throws Exception
	{
		List<RecordVO> list = new ArrayList();

		new DBExecutor((con,pstmt,rs) -> {
			pstmt = con.prepareStatement("select * from(select rownum,RTITLE,RCONTENTS,MID, MODIFYDATE, RNOTICE, RID from TBL_RECORD where RNOTICE='y' order by modifydate desc) where rownum<6");
			
			rs = pstmt.executeQuery();

					
			while(rs.next())
			{	
				RecordVO vo = new RecordVO();
				vo.setRtitle(rs.getString(2));
				vo.setRcontent(rs.getString(3));
				vo.setMid(rs.getString(4));	
				vo.setModifydate(rs.getDate(5));
				vo.setRid(rs.getInt(7));
				
				list.add(vo);
			}
	
		}).execute();
		
		return list;
	}	
	
			
		public static int findRecordNumber(String mid)throws Exception
		{
			count = 0;
			
			new DBExecutor((con,pstmt,rs) -> {
				pstmt = con.prepareStatement("select count(rownum) from tbl_record where mid=?");

				pstmt.setString(1, mid);
				
				rs = pstmt.executeQuery();

				rs.next();
				
				count = rs.getInt(1);
		
			}).execute();
			
			return count;
		}		
			
			
	public static List<RecordVO> myRead(String mid)throws Exception
	{
		List<RecordVO> list = new ArrayList();
		
		new DBExecutor((con,pstmt,rs) -> {
			pstmt = con.prepareStatement("select rownum,RTITLE,RCONTENTS,MODIFYDATE, RSHARE, Rid from TBL_RECORD where mid=? order by modifydate desc");
			
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();

			int rowCnt = 0;
			
			while(rs.next())
			{	
				RecordVO vo = new RecordVO();
				vo.setRtitle(rs.getString(2));
				vo.setRcontent(rs.getString(3));	 
				vo.setModifydate(rs.getDate(4));
				vo.setRshare(rs.getString(5));
				vo.setRid(rs.getInt(6));
				
				rowCnt++;
				
				list.add(vo);			
			}
			
	
		}).execute();
		
		return list;
	}
	
	  ;
	
	
	public static List<RecordVO> myRead2(String mid, int page)throws Exception
	{
		List<RecordVO> list = new ArrayList();
		
		int pagefirst = page*10-9;
		int pagelast = page*10;
		
		new DBExecutor((con,pstmt,rs) -> {
			pstmt = con.prepareStatement("select * from ( SELECT * FROM ( SELECT rownum rnum, rtitle, rcontents, modifydate, rshare, rid FROM TBL_RECORD where mid=? )emp where rnum <= ?)where rnum >= ?");
			
			pstmt.setString(1, mid);
			pstmt.setInt(2, pagelast);
			pstmt.setInt(3, pagefirst);
			rs = pstmt.executeQuery();

			
			while(rs.next())
			{	
				RecordVO vo = new RecordVO();
				
				vo.setRtitle(rs.getString(2));
				vo.setRcontent(rs.getString(3));	 
				vo.setModifydate(rs.getDate(4));
				vo.setRshare(rs.getString(5));
				vo.setRid(rs.getInt(6));

				list.add(vo);			
			}
			
	
		}).execute();
		
		return list;
	}
	
	  public static void mylistInsert(RecordVO vo) throws Exception{
		  
		  System.out.println("start insert");
		  
	      new DBExecutor((con,pstmt,rs) -> {
	         pstmt = con.prepareStatement("insert  into tbl_record (rid ,rtitle, mid,rcontents,rshare, rnotice) "
	               + "values(seq_rid.nextval,?,?,?,?,?)");
	         
	         pstmt.setString(1, vo.getRtitle());   
	         pstmt.setString(2, vo.getMid());
	         pstmt.setString(3, vo.getRcontent());
	         pstmt.setString(4, vo.getRshare());
	         pstmt.setString(5, vo.getRnotice());
	         
	         pstmt.executeUpdate();
	         
	      }).execute();
	      
	  }
	  
	  public List<RecordVO> searchByRecent(String search) throws Exception
	  {
		  List<RecordVO> list = new ArrayList();
		  RecordVO vo = new RecordVO();
		  
		  
	      new DBExecutor((con,pstmt,rs) -> {
		         pstmt = con.prepareStatement("select rtitle, rcontents, mid, modifydate, rhits, rwho from TBL_RECORD where mid like ? or RCONTENTS like ? or rtitle like ? order by MODIFYDATE desc ");
		         
		         String value = "%"+search+"%";
		         
		         pstmt.setString(1, value);
		         pstmt.setString(2, value);
		         pstmt.setString(3, value);
		         
		         rs = pstmt.executeQuery();

		         while(rs.next())
		         {
		        	 vo.setRtitle(rs.getString(1));
		        	 vo.setRcontent(rs.getString(2));
		        	 vo.setMid(rs.getString(3));
		        	 vo.setModifydate(rs.getDate(4));
		        	 vo.setRhits(rs.getInt(5));
		        	 vo.setRwho(rs.getString(6));
		        	 		        	 
		        	 list.add(vo);
		         }
		         
		      }).execute();
		            
		  	return list;
	  }
	  
	  
	  public List<RecordVO> searchByHits(String search) throws Exception
	  {
		  List<RecordVO> list = new ArrayList();
		  RecordVO vo = new RecordVO();
		  
	      new DBExecutor((con,pstmt,rs) -> {
		         pstmt = con.prepareStatement("select rtitle, rcontents, mid, modifydate, rhits, rwho from TBL_RECORD where mid like ? or RCONTENTS like ? or rtitle like ? order by rhits desc ");

		         String value = "%"+search+"%";
		         
		         pstmt.setString(1, value);
		         pstmt.setString(2, value);
		         pstmt.setString(3, value);
		         
		         rs = pstmt.executeQuery();

		         while(rs.next())
		         {
		        	 vo.setRtitle(rs.getString(1));
		        	 vo.setRcontent(rs.getString(2));
		        	 vo.setMid(rs.getString(3));
		        	 vo.setModifydate(rs.getDate(4));
		        	 vo.setRhits(rs.getInt(5));
		        	 vo.setRwho(rs.getString(6));
		        	 		        	 
		        	 list.add(vo);
		         }
		         
		      }).execute();
		            
		  	return list;
	  }
	  
	  
	  public List<RecordVO> searchByRecommend(String search) throws Exception
	  {
		  List<RecordVO> list = new ArrayList();
		  RecordVO vo = new RecordVO();
		  
	      new DBExecutor((con,pstmt,rs) -> {
		         pstmt = con.prepareStatement("select rtitle, rcontents, mid, modifydate, rhits, rwho from TBL_RECORD where mid like ? or RCONTENTS like ? or rtitle like ? order by rwho desc ");

		         String value = "%"+search+"%";
		         
		         pstmt.setString(1, value);
		         pstmt.setString(2, value);
		         pstmt.setString(3, value);
		         
		         rs = pstmt.executeQuery();

		         while(rs.next())
		         {
		        	 vo.setRtitle(rs.getString(1));
		        	 vo.setRcontent(rs.getString(2));
		        	 vo.setMid(rs.getString(3));
		        	 vo.setModifydate(rs.getDate(4));
		        	 vo.setRhits(rs.getInt(5));
		        	 vo.setRwho(rs.getString(6));
		        	 		        	 
		        	 list.add(vo);
		         }
		         
		      }).execute();
		            
		  	return list;
	  }
	  
	  
	  public static List<RecordVO> searchByFirst() throws Exception
	  {
		  List<RecordVO> list = new ArrayList();
		  
		  
	      new DBExecutor((con,pstmt,rs) -> {
		         pstmt = con.prepareStatement("select rtitle, rcontents, mid, modifydate, rhits, rpoint, rid from TBL_RECORD order by MODIFYDATE desc");
		         
		         rs = pstmt.executeQuery();
		         
		         while(rs.next())
		         {
		        	 RecordVO vo = new RecordVO();
		        	 vo.setRtitle(rs.getString(1));
		        	 vo.setRcontent(rs.getString(2));
		        	 vo.setMid(rs.getString(3));
		        	 vo.setModifydate(rs.getDate(4));
		        	 vo.setRhits(rs.getInt(5));
		        	 vo.setRpoint(rs.getInt(6));
		        	 vo.setRid(rs.getInt(7));

		        	 list.add(vo);
		         }
		      }).execute();
		            
		  	return list;
	  }
	  
	  
	  public static RecordVO mypostView(String id) throws Exception
	  {  
		  RecordVO vo = new RecordVO();
		  
	      new DBExecutor((con,pstmt,rs) -> {
		         pstmt = con.prepareStatement("select emp.RTITLE, emp.MODIFYDATE, emp2.MNAME, emp.RCONTENTS, emp.RFILE, emp.RWHO, emp.RHITS, emp.RPoint, emp.Rshare, emp.RNotice from(select * from TBL_RECORD where rid=?)emp, tbl_member emp2 where emp.mid=emp2.mid");
		         
		         pstmt.setString(1, id);
		         rs = pstmt.executeQuery();
		         
		         while(rs.next())
		         {	
		        	vo.setRtitle(rs.getString(1));
		        	vo.setModifydate(rs.getDate(2));
		        	vo.setMid(rs.getString(3));
		        	vo.setRcontent(rs.getString(4));
		        	vo.setRwho(rs.getString(6));
		        	vo.setRhits(rs.getInt(7));
		        	vo.setRpoint(rs.getInt(8));
		        	
		        	vo.setRshare(rs.getString(9));
		        	vo.setRnotice(rs.getString(10));
		         }
		      }).execute();
		            
		  	return vo;
	  }
	  
	  
	  
	  
	  public static void mypostModify(RecordVO vo) throws Exception
	  {  
		  		  
	      new DBExecutor((con,pstmt,rs) -> {
		         pstmt = con.prepareStatement("UPDATE tbl_record SET RTITLE=?, RCONTENTS=?,RSHARE=?,RNOTICE=?,MODIFYDATE=sysdate WHERE rid=?");
		         
		         pstmt.setString(1, vo.getRtitle());
		         pstmt.setString(2, vo.getRcontent());
		         pstmt.setString(3, vo.getRshare());
		         pstmt.setString(4, vo.getRnotice());
		         pstmt.setInt(5, vo.getRid());
		         pstmt.executeUpdate();
		         
		      }).execute();

	  }

		public static void deleteRecord(String rid)
		{		
			new DBExecutor((con,pstmt,rs) -> {
				pstmt = con.prepareStatement("delete from tbl_record where rid=?");
				
				pstmt.setString(1, rid);
				pstmt.executeUpdate();
				
			}).execute();
		}
}

