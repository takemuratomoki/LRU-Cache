package lruCache;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class LRUCacheTest {
	
	//�e�X�g�p�錾
	LRUCacheClass lru = new LRUCacheClass();
	
	@Test
	public void _0�Ԗڂ̗v�f�Ɋi�[����put�֐��e�X�g(){
		try {
//			lru.put("hoge1", "hogehoge1");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void ������1��Ԃ�get�֐��e�X�g() {
		assertThat(lru.get("hoge1"),is("1"));
	}
	
}
