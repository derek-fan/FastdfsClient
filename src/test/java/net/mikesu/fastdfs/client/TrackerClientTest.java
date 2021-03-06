package net.mikesu.fastdfs.client;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import net.mikesu.fastdfs.data.GroupInfo;
import net.mikesu.fastdfs.data.Result;
import net.mikesu.fastdfs.data.UploadStorage;

import org.junit.Test;

public class TrackerClientTest {

	private final static String FDFS_IP = "192.168.6.68";
	
	@Test
	public void testGetUploadStorageAddr() throws NumberFormatException, UnknownHostException, IOException {
		TrackerClient trackerClient = new TrackerClientImpl(FDFS_IP + ":22122");
		Result<UploadStorage> result = trackerClient.getUploadStorage();
		assertEquals(0, result.getCode());
		assertEquals(FDFS_IP + ":23000",result.getData().getAddress());
		trackerClient.close();
	}
	
	@Test
	public void testGetDownloadStorageAddr() throws IOException {
		TrackerClient trackerClient = new TrackerClientImpl(FDFS_IP + ":22122");
		Result<String> result = trackerClient.getDownloadStorageAddr("group1","M00/00/00/Cn2wilM00puAa0xSAANVQ4eIxAM143.jpg");
		assertEquals(0, result.getCode());
		assertEquals(FDFS_IP + ":23000",result.getData());
		trackerClient.close();
	}
	
	@Test
	public void testGetUpdateStorageAddr() throws IOException {
		TrackerClient trackerClient = new TrackerClientImpl(FDFS_IP + ":22122");
		Result<String> result = trackerClient.getUpdateStorageAddr("group1","M00/00/00/Cn2wilM00puAa0xSAANVQ4eIxAM143.jpg");
		assertEquals(0, result.getCode());
		assertEquals(FDFS_IP + ":23000",result.getData());
		trackerClient.close();
	}
	
	@Test
	public void testGetGroupInfos() throws NumberFormatException, UnknownHostException, IOException{
		TrackerClient trackerClient = new TrackerClientImpl(FDFS_IP + ":22122");
		Result<List<GroupInfo>> groupInfos = trackerClient.getGroupInfos();
		assertNotNull(groupInfos);
		trackerClient.close();
	}
}
