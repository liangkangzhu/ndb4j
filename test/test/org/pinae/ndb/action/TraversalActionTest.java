package test.org.pinae.ndb.action;

import org.pinae.ndb.action.TraversalAction;

public class TraversalActionTest implements TraversalAction {

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
