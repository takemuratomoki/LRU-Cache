package lruCache;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class LRUCacheTest {
	
	//テスト用宣言
	LRUCacheClass lru = new LRUCacheClass();
	
	@Test
	public void _0番目の要素に格納するput関数テスト(){
		try {
//			lru.put("hoge1", "hogehoge1");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void 文字列1を返すget関数テスト() {
		assertThat(lru.get("hoge1"),is("1"));
	}
	
}
