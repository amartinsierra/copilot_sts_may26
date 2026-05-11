package com.caixaba.absis.microtypi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
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
		return restClient.get()
				.uri(urlBase + "/posts")
				.retrieve()
				.body(new ParameterizedTypeReference<List<Post>>() {});
	}

	@Override
	public List<Comment> getCommentsByPost(Integer postId) {
		return restClient.get()
				.uri(urlBase + "/posts/" + postId + "/comments")
				.retrieve()
				.body(new ParameterizedTypeReference<List<Comment>>() {});
	}

	@Override
	public void createPost(Post post) {
		restClient.post()
				.uri(urlBase + "/posts")
				.body(post)
				.retrieve()
				.onStatus(status -> status.isError(), (request, response) -> {
					throw new RuntimeException("Error al crear el post: " + response.getStatusCode());
				})
				.toBodilessEntity();
	}

}