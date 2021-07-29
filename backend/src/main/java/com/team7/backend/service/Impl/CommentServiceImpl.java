package com.team7.backend.service.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.team7.backend.model.Comment;
import com.team7.backend.service.CommentService;
import com.team7.backend.service.FirebaseInitService;
import com.team7.backend.service.constants.ServiceConstants;

@Service
public class CommentServiceImpl implements CommentService {
	
	Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

	@Autowired
	FirebaseInitService db;

	@Override
	public List<Comment> retrieveAllComments() throws InterruptedException, ExecutionException {

		List<Comment> commentsList = new ArrayList<Comment>();
		CollectionReference collectionList = db.getFirebase().collection(ServiceConstants.COL_NAME);
		ApiFuture<QuerySnapshot> querySnapshotApiFuture = collectionList.get();
		for (DocumentSnapshot documentSnapshot : querySnapshotApiFuture.get().getDocuments()) {
			Comment comment = documentSnapshot.toObject(Comment.class);
			commentsList.add(comment);
		}
		return commentsList;
	}

	@Override
	public int saveComment(Comment comment) throws ExecutionException, InterruptedException {
		
		logger.info(ServiceConstants.SAVE_COMMENT_PROCESS_STARTED);
		CollectionReference collectionAdd = db.getFirebase().collection(ServiceConstants.COL_NAME);
		collectionAdd.document(String.valueOf(comment.getId())).set(comment);
		
		logger.info(ServiceConstants.SAVE_COMMENT_COMMENT_INSERTED, comment.getId());
		logger.info(ServiceConstants.SAVE_COMMENT_PROCESS_FINISHED);
		return comment.getId();
	}

	@Override
	public List<Comment> retrieveCommentsById(String pictureId) throws ExecutionException, InterruptedException {
		List<Comment> commentsList = new ArrayList<Comment>();
		CollectionReference collectionList = db.getFirebase().collection(ServiceConstants.COL_NAME);
		// Query query = collectionList.whereIn("pictureId", Arrays.asList("6"));
		ApiFuture<QuerySnapshot> querySnapshotApiFuture = collectionList
				.whereIn(ServiceConstants.FIELD_NAME, Collections.singletonList(pictureId)).get();
		for (DocumentSnapshot documentSnapshot : querySnapshotApiFuture.get().getDocuments()) {
			Comment comment = documentSnapshot.toObject(Comment.class);
			commentsList.add(comment);
		}
		return commentsList;
	}

}
