package com.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.ClusterDao;
import com.spring.rest.entity.Cluster;

@Service("clusterService")
public class ClusterService {

	@Autowired
	private ClusterDao clusterDao;

	public Cluster saveCluster(Cluster cluster) {
		Cluster clusterSaved = null;

		try {
			clusterSaved = clusterDao.insertCluster(cluster);
		} catch (Exception e) {
			//throw new DuplicateClusterKeyException(cluster.getId());
		}
		return clusterSaved;
	}

	public Cluster updateCluster(Cluster cluster) {
		return clusterDao.updateCluster(cluster);
	}

	public List<Cluster> getAllClusters() {

		return clusterDao.selectAllCluster();

	}

	public void removeClusterById(String clusterId) {
		clusterDao.deleteClusterById(clusterId);
	}

	public Cluster findClusterById(String clusterId) {
		Cluster cluster = null;
		cluster = clusterDao.getClusterById(clusterId);
		//if(cluster==null)
			//throw new ClusterNotFoundException(clusterId);
		
		return cluster;
	}
}
