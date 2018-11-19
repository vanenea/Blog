package com.blog.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.admin.service.IBoardService;
import com.blog.mapper.TAttachMapper;
import com.blog.mapper.TCommentsMapper;
import com.blog.mapper.TContentsMapper;
import com.blog.mapper.TLogsMapper;
import com.blog.mapper.TMetasMapper;
import com.blog.model.TComments;
import com.blog.model.TContents;
import com.blog.model.TLogs;
import com.blog.model.TMetasExample;

@Service("boardService")
public class BoardServiceImpl implements IBoardService {

	@Autowired
	private TContentsMapper contentsMapper;
	
	@Autowired
	private TCommentsMapper commentsMapper;
	
	@Autowired
	private TAttachMapper attachMapper;
	
	@Autowired
	private TMetasMapper metasMapper;
	
	@Autowired
	private TLogsMapper logsMapper;
	
	@Override
	public Map<String, Object> boardInfor() {
		Map<String, Object> result = new HashMap<>();
//		TContentsExample example = new TContentsExample();
//		Criteria createCriteria = example.createCriteria();
		int contentsCount = contentsMapper.countByExample(null);
		int commentsCount = commentsMapper.countByExample(null);
		int attachCount = attachMapper.countByExample(null);
		TMetasExample example = new TMetasExample();
		example.createCriteria().andTypeEqualTo("link");
		int linkCount = metasMapper.countByExample(example );
		List<TContents> contentsList = contentsMapper.selectByExample(null);
		List<TComments> commentsList = commentsMapper.selectByExampleWithBLOBs(null);
		List<TLogs> logsList = logsMapper.selectByExample(null);
		result.put("contentsCount", contentsCount);
		result.put("commentsCount", commentsCount);
		result.put("attachCount", attachCount);
		result.put("linkCount", linkCount);
		result.put("contentsList", contentsList);
		result.put("commentsList", commentsList);
		result.put("logsList", logsList);
		return result;
	}
	
}
