import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**
 * @author Jin Guopan
   @creation 2016年12月21日
 */
public class TestVideoMsg {
	public static void main(String[] args) {
		String json="{\"videoData\":{\"arg0\":\"2\",\"audit_dt\":0,\"audit_user\":\"\",\"bigCover\":\"http://223.img.pp.sohu.com.cn/p223/2016/12/21/8/11/6_159fef7c8aag104SysCutcloud_86613443_7_4b.jpg\",\"cate_code\":192103,\"comments\":\"0\",\"commentsId\":\"-1\",\"count\":\"0\",\"cover170\":\"http://img.my.tv.sohu.com.cn/o_zoom,w_170,h_110/p223/2016/12/21/8/11/6_159fef7c8aag104SysCutcloud_86613443_7_4b.jpg\",\"create_dt\":0,\"filing_no\":\"\",\"h_clipsBytes\":[\"9122186\"],\"h_clipsDuration\":[\"135\"],\"h_downloadurl\":\"http://121.46.19.92/?new=/238/100/s94C6NsYoRlLWnbnIDI96L.mp4&key=4Rx89iq6LbKI1LUV86Kx_0x6arIkOiF0&prod=ugc&pt=pc&pg=0&cateCode=192103&vid=86613443&ch=my\",\"introduction\":\"八旬老人迷失 救援队全城搜寻\",\"is_act\":0,\"is_finish_info\":0,\"is_pay\":0,\"lastModified\":1482285180139,\"likes\":\"0\",\"n_clipsBytes\":[\"9122186\"],\"n_clipsDuration\":[\"135\"],\"n_downloadurl\":\"http://121.46.19.92/?new=/238/100/s94C6NsYoRlLWnbnIDI96L.mp4&key=4Rx89iq6LbKI1LUV86Kx_0x6arIkOiF0&prod=ugc&pt=pc&pg=0&cateCode=192103&vid=86613443&ch=my\",\"nofc_operator\":0,\"parts\":\"0\",\"playUrl\":\"http://my.tv.sohu.com/us/176171857/86613443.shtml\",\"play_type\":0,\"plevel\":0,\"publisher\":0,\"refers\":\"0\",\"release_time\":0,\"shares\":\"0\",\"smallCover\":\"http://223.img.pp.sohu.com.cn/p223/2016/12/21/8/11/6_159fef7c8aag104SysCutcloud_86613443_7_4.jpg\",\"status\":0,\"str_cate_code\":\"其他\",\"sum\":\"0\",\"tags\":\" \",\"ugcode\":\"\",\"ugu\":\"\",\"update_dt\":1482278757391,\"update_time\":1482289523322,\"uploadFrom\":7,\"uploadIp\":\"223.74.191.70\",\"upload_dt\":1482278757391,\"userName\":\"夏天脚步\",\"user_id\":176171857,\"user_level\":0,\"verType\":\"21\",\"videoLevel\":1110,\"videoSize\":\"9122186\",\"videoStatus\":0,\"videoType\":10,\"video_id\":86613443,\"video_length\":135,\"video_status\":40,\"video_title\":\"八旬老人迷失 救援队全城搜寻\"}}";
		JSONObject  jsonObject= JSON.parseObject(json);
		String title=jsonObject.getJSONObject("videoData").getString("video_title");
		String introduction = jsonObject.getJSONObject("videoData").getString("introduction");
		String playUrl = jsonObject.getJSONObject("videoData").getString("playUrl"); 
		System.out.println("title "+title);
		System.out.println("introduction "+introduction);
		System.out.println("playUrl "+playUrl);
	}

}
