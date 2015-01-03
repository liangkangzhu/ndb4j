package test.org.pinae.ndb.common;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.pinae.ndb.common.MapHelper;

public class MapHelperTest {
	@Test
	public void testToString() {
		Map<String, String> map = MapHelper.toMap(new String[]{"name" , "age", "phone"}, 
				new String[]{"hui", "30", "13343351822"});
		String value = MapHelper.toString(map, "{name}|{age}|{phone}");
		assertEquals(value, "hui|30|13343351822");
	}
}
