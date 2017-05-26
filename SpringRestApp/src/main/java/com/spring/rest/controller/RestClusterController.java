package com.spring.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Cluster;
import com.spring.rest.service.ClusterService;
import com.spring.rest.uri.ClusterRestURIConstants;

@RestController("clusterController")
public class RestClusterController {
	private static final Logger logger = LoggerFactory
			.getLogger(RestClusterController.class);

	@Autowired
	private ClusterService clusterService;

	// Map to store Clusters, ideally we should use database
	Map<Integer, Cluster> clusterData = new HashMap<Integer, Cluster>();

	// GET DUMMY CLUSTER - BY RABINDRA PATRA
	@RequestMapping(value = ClusterRestURIConstants.DUMMY_CLUSTER, method = RequestMethod.GET)
	public @ResponseBody
	Cluster getDummyCluster() {
		logger.info("Start getDummyCluster");
		Cluster cluster = new Cluster("1", "CL1", "CL1-DESC", "1");
		
		System.out.println(cluster);
		clusterData.put(9999, cluster);
		return cluster;
	}

	
	// GET CLUSTER BY ID - BY RABINDRA PATRA
	@RequestMapping(value = ClusterRestURIConstants.GET_CLUSTER, method = RequestMethod.GET)
	public ResponseEntity<Cluster> getCluster(@PathVariable("id") String clusterId) {
		logger.info("Start getCluster. ID=" + clusterId);
		ResponseEntity<Cluster> response = null;
		Cluster cluster = clusterService.findClusterById(clusterId);
		response = new ResponseEntity<>(cluster, HttpStatus.OK);
		logger.info("returning cluster by id: " + clusterId);
		return response;
	}

	// GET CLUSTER LIST - BY RABINDRA PATRA
	@RequestMapping(value = ClusterRestURIConstants.GET_ALL_CLUSTER, method = RequestMethod.GET)
	public ResponseEntity<List<Cluster>> getAllClusters() {

		logger.info("Start getAllClusters.");
		ResponseEntity<List<Cluster>> response = null;
		List<Cluster> clusters = clusterService.getAllClusters();
		System.out.println(clusters);
		response = new ResponseEntity<>(clusters, HttpStatus.OK);
		logger.info("returning cluster list");
		return response;

	}

	// CREATE NEW CLUSTER - BY RABINDRA PATRA
	@RequestMapping(value = ClusterRestURIConstants.CREATE_CLUSTER, method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Cluster> createCluster(@RequestBody Cluster cluster) {
		logger.info("Start createCluster.");
		ResponseEntity<Cluster> response = null;
		response = new ResponseEntity<>(clusterService.saveCluster(cluster), HttpStatus.OK);
		return response;
	}

	// UPDATE AN EXISTING CLUSTER - BY RABINDRA PATRA
	@RequestMapping(value = ClusterRestURIConstants.UPDATE_CLUSTER, method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Cluster> updateCluster(@PathVariable("id") String clusterId,@RequestBody Cluster cluster) {
		logger.info("Start updateCluster.");
		ResponseEntity<Cluster> response = null;
		cluster.setId(clusterId);
		response = new ResponseEntity<>(
				clusterService.updateCluster(cluster), HttpStatus.OK);
		logger.info("Cluster updated.");
		return response;

	}

	// DELETE A CLUSTER BY ID - BY RABINDRA PATRA
	@RequestMapping(value = ClusterRestURIConstants.DELETE_CLUSTER, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCluster(
			@PathVariable("id") String clusterId) {
		logger.info("Start deleteCluster.");

		ResponseEntity<String> response = null;
		clusterService.removeClusterById(clusterId);
		response = new ResponseEntity<>("Cluster Deleted: " + clusterId,
				HttpStatus.OK);
		logger.info("Cluster Deleted");
		return response;
	}
}
