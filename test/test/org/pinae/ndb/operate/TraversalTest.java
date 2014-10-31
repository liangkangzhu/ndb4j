package test.org.pinae.ndb.operate;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;
import org.pinae.ndb.action.TraversalAction;
import org.pinae.ndb.common.NodeReader;
import org.pinae.ndb.operate.Traversal;

public class TraversalTest {
	
	@Test
	public void testTraversal(){
		NodeReader parser = new NodeReader();
		
		Traversal traversal = new Traversal();
		
		try {
			
			Map<String, Object> configMap = parser.read("config.txt");
			
			Map<String, Object> map = traversal.traversal(configMap, new TraversalActionTest());
			
			
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	public static class TraversalActionTest implements TraversalAction {

		@Override
		public String handleKey(String key) {
			String newKey = "";

			if (key.indexOf("-") > -1) {
				String keys[] = key.split("-");
				for (String _key : keys){
					newKey += _key;
				}
			} else {
				newKey = key;
			}
			return newKey;
		}

		@Override
		public Object handleValue(Object value) {
			return value;
		}


	}
	
}
