package bahaso.testing.general;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class cobamongo {
	MongoClient mongoClient = null;
	MongoDatabase db = null;

	@BeforeClass
	public void beforeClass() {
		try {
			// STEP 1: Connect to database
			mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDatabase("bahaso");
			System.out.println("Connect to database successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	@Test
	public void test() throws Exception {
		try {
			// STEP 2: Get Collection
			MongoCollection<Document> table = db.getCollection("case_types");
			// STEP 3: Extract Data
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("_id", new ObjectId("567925d1938e8e651c8b4579"));
			FindIterable<Document> cursor = table.find();
			
			// STEP 4: Iterate over data
			for (Document obj : cursor) {
				//ArrayList<Document> courses = (ArrayList<Document>) obj.get("choices");
				//String lastName = obj.getString("question");
				//System.out.println("jumlahnya ada : " + courses.size());
//				String no = obj.getString("no");
//				String type =  obj.getString("text");
//				System.out.println(no + " " + type);
				System.out.println(obj.get("no") + " " + obj.get("text"));
			}
			
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	
}
