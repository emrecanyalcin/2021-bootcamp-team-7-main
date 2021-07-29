package com.team7.backend.service.constants;

public class ServiceConstants {

	public static final String COL_NAME = "comment";
	public static final String FIELD_NAME = "pictureId";

	/**
	 * CommentController Generic Constants
	 */
	public static final String COMMENT_SERVICE_PROCESS_STARTED = "CommentService Process Started - ";
	public static final String COMMENT_SERVICE_PROCESS_FINISHED = "CommentService Process Finished";

	/**
	 * CommentController Method Constants
	 */
	public static final String METHOD_CALL_GET_ALL_COMMENTS = "retrieveAllComments() method was called!";
	public static final String METHOD_CALL_GET_COMMENTS_BY_ID = "retrieveCommentsById() method was called!";
	public static final String METHOD_CALL_SAVE_COMMENT = "saveComment() method was called!";

	/**
	 * CommentService SaveComment Constants
	 */
	public static final String SAVE_COMMENT_PROCESS_STARTED = "CommentService - SAVE_COMMENT - Process Started!";
	public static final String SAVE_COMMENT_COMMENT_INSERTED = "CommentService - SAVE_COMMENT - Comment Inserted with ID: {}";
	public static final String SAVE_COMMENT_PROCESS_FINISHED = "CommentService - SAVE_COMMENT - Process Finished!";

}
