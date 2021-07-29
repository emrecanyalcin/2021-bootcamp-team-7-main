package com.team7.backend.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.team7.backend.model.Comment;
import com.team7.backend.service.CommentService;
import com.team7.backend.service.constants.ServiceConstants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {

	Logger logger = LoggerFactory.getLogger(CommentController.class);

	@Autowired
	CommentService commentService;

	@ApiOperation(value = "View all comments.", response = Comment.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved the list!"),
			@ApiResponse(code = 401, message = "Not authorized to view the list!"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden!"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found!"),

	})
	@GetMapping("/comments")
	public List<Comment> getAllComments() throws ExecutionException, InterruptedException {
		logger.info(ServiceConstants.COMMENT_SERVICE_PROCESS_STARTED + ServiceConstants.METHOD_CALL_GET_ALL_COMMENTS);

		List<Comment> comments = commentService.retrieveAllComments();

		logger.info(ServiceConstants.COMMENT_SERVICE_PROCESS_FINISHED);

		return comments;
	}

	@ApiOperation(value = "Comments are received according to the id of the picture.", response = Comment.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved the list!"),
			@ApiResponse(code = 401, message = "Not authorized to view the list!"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden!"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found!"),

	})
	@GetMapping("/comments/{pictureId}")
	public List<Comment> getCommentsById(@PathVariable(value = "pictureId") String pictureId)
			throws ExecutionException, InterruptedException {

		logger.info(ServiceConstants.COMMENT_SERVICE_PROCESS_STARTED + ServiceConstants.METHOD_CALL_GET_COMMENTS_BY_ID);

		List<Comment> comments = commentService.retrieveCommentsById(pictureId);

		logger.info(ServiceConstants.COMMENT_SERVICE_PROCESS_FINISHED);

		return comments;
	}

	@ApiOperation(value = "Create new comment.", response = Comment.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved the list!"),
			@ApiResponse(code = 401, message = "Not authorized to view the list!"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden!"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found!"),

	})
	@PostMapping("/comments/save")
	public int saveComment(@RequestBody Comment comment) throws ExecutionException, InterruptedException {

		logger.info(ServiceConstants.COMMENT_SERVICE_PROCESS_STARTED + ServiceConstants.METHOD_CALL_SAVE_COMMENT);

		int commentId = commentService.saveComment(comment);

		logger.info(ServiceConstants.COMMENT_SERVICE_PROCESS_FINISHED);

		return commentId;

	}

}
