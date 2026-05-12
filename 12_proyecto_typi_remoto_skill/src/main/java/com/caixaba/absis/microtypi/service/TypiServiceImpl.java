package com.caixaba.absis.microtypi.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.capgemini.microtypi.api.domain.Comment;
import com.capgemini.microtypi.api.domain.Post;
@Service
public class TypiServiceImpl implements TypiService {
	@Value("${typi.url.base}")
	private String urlBase;
	
	private RestClient restClient;

	public TypiServiceImpl(RestClient restClient) {
		this.restClient = restClient;
	}

	@Override
	public List<Post> getPosts() {
		return Arrays.asList(restClient.get()
			.uri(urlBase + "/posts")
			.retrieve()
			.body(Post[].class));
	}

	@Override
	public List<Comment> getCommentsByPost(Integer postId) {
		
	}

	@Override
	public void createPost(Post post) {
		restClient.post()
			.uri(urlBase + "/posts")
			.contentType(MediaType.APPLICATION_JSON)
			.body(post)
			.retrieve()
			.toBodilessEntity();
	}

}