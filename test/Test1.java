package test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;







import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.model.Article;
import com.yc.model.Article_detail;
import com.yc.model.Article_mdetail;
import com.yc.model.Article;
import com.yc.model.Comment;
import com.yc.model.ReComment;
import com.yc.model.Tag;
import com.yc.model.User;
import com.yc.tool.BCrypt;
import com.yc.tool.MD5;

public class Test1 {
//	@Test
	public void getHashed(){
		String plaintext = "1234";
		Integer length = plaintext.length();
		String text = MD5.GetMD5Code(plaintext.substring(length / 2 , length) + "hash" + plaintext.substring(0 ,length/2 ) );
		System.out.println(text);
	}
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-datasource.xml");
		SessionFactory sessionFactory  = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<String> object = session.createQuery("select a.id from Article a order by a.readNum + a.commentNum +date_format(a.createDate,'%Y%m%d')  desc").setMaxResults(10).list();
		for(String str: object){
			System.out.println(str);
		}
		System.out.println(object.size());
//		BackArticle article = new BackArticle();
//		article.setAuthor("author");
//		article.setCoverImg("htt[:hehe.com");
//		Article_detail article_detail = new Article_detail();
//		Article_mdetail article_mdetail = new Article_mdetail();
//		article_detail.setContent("hehe1");
//		article_mdetail.setContent("mhehe2");
//		article_mdetail.setBackArticle(article);
//		article.setArticle_detail(article_detail);
//		article.setArticle_mdetail(article_mdetail);
//		session.save(article);
//		BackArticle article = (BackArticle) session.load(BackArticle.class, 1);
//		System.out.println(article);
//		session.delete(article);
//		String hql = "select a.id from Comment c left join c.article a where c.id = ?";
//		String hql ="update Article ac  set ac.commentNum = ac.commentNum + 1 where  ac.id = (select c.id from  ( select a.id from Comment c left join c.article a where c.id = ?) c )";
//		String hql = "select c.id,c.content,c.createDate,c.praiseNum ,c.commentNum , cr from Comment c left join c.user cu left join c.article ca left join c.reComments cr  where c.isDeleted = 0 and ca.id=:ca_id order by c.createDate desc";
//		Integer  id = (Integer) session.createQuery(hql).setParameter(0,1).uniqueResult();
//		System.out.println(id);
		
//		String hql = "select c.id from Comment c ";
//		List<Integer> cids = session.createQuery(hql).list();
//		for (Integer cid : cids ){
//			Integer lastId = null;
//			for(int i = 0 ; i < 10; i ++){
//				ReComment reComment = new ReComment();
//				reComment.setComment(new Comment().setId(cid));
//				reComment.setContent("评论id为"+cid + "的评论" + i);
//				reComment.setReCommentId(lastId);
//				lastId = (Integer) session.save(reComment);
//			}
//		}
		
//		for(int i = 0 ; i < 10 ; i ++){
//			User user = new User();
//			user.setHeadImg(i+"xxx.jpg");
//			user.setName("姓名"+i);
//			user.setPassword(BCrypt.hashpw("zenghao"));
//			user.setPhoneNum("zenghao" + i);
//			
//			session.save(user);
//			
//			Tag tag = new Tag();
//			tag.setName("标签" + i);
//			
//			session.save(tag);
//			
//			Article article = new Article();
//			article.setAuthor("作者"+i);
//			article.setContent("内容" + i);
//			article.setCoverImg("封面图片"+ i);
//			article.setTag(tag);
//			article.setTitle("标题"+i);
//			session.save(article);
//			
//			for(int j = 0 ; j < 10 ; j ++){
//				Comment comment = new Comment();
//				comment.setArticle(article);
//				comment.setUser(user);
//				comment.setContent("评论内容" + i + j);
//				session.save(comment);
//			}
//			
//		}
		
		tx.commit();
		session.close();
	}
	
	protected static boolean verify(String plaintext,String hashed){
		Integer length = plaintext.length();
		String text = plaintext.substring(length / 2 , length) + "hash" + plaintext.substring(0 ,length/2  );
		System.out.println(text);
		return MD5.GetMD5Code(text).equals( hashed);
	}
	
    public static int AddOneArticle(String url,String title, String author, String coverImg, String content) throws IOException {
        URL url1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
        connection.setReadTimeout(5000);
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(("title="+title+"&author="+author+"&coverImg="+coverImg+"&content="+content).getBytes());
        os.flush();
        os.close();
        return connection.getResponseCode();
    }
}