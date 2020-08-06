package client.comment.board.action;

public  class encodeContent {
	
	public String encoding(String content) {
		
		String ret = content;
		try {
		ret=ret.replace("&", "&amp;");
		ret=ret.replace("<", "&lt;");
		ret=ret.replace(">", "&gt;");
		} catch (NullPointerException e) {
		e.printStackTrace();
		}
		return ret;
		}
	}
