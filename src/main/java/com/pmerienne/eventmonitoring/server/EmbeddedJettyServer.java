package com.pmerienne.eventmonitoring.server;

import java.net.URL;
import java.security.ProtectionDomain;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedJettyServer {

	private final static Logger LOGGER = Logger.getLogger(EmbeddedJettyServer.class);

	public static void main(String[] args) throws Exception {
		// Start a Jetty server with some sensible(?) defaults
		try {

			// Get configuration
			int port = Integer.parseInt(System.getProperty("port", "8080"));
			int gracefulShutdown = Integer.parseInt(System.getProperty("gracefulShutdown", "5000"));
			int maxThread = Integer.parseInt(System.getProperty("maxThread", "100"));
			int connectorIdleTime = Integer.parseInt(System.getProperty("connectorIdleTime", "30000"));

			// Allow some time to complete shutdown
			Server server = new Server(port);
			server.setStopAtShutdown(true);
			server.setGracefulShutdown(gracefulShutdown);

			// Configure thread pool
			QueuedThreadPool threadPool = new QueuedThreadPool();
			threadPool.setMaxThreads(maxThread);
			server.setThreadPool(threadPool);

			// Ensure using the non-blocking connector (NIO)
			Connector connector = new SelectChannelConnector();
			connector.setPort(port);
			connector.setMaxIdleTime(connectorIdleTime);
			server.setConnectors(new Connector[] { connector });

			// Get war file
			ProtectionDomain domain = EmbeddedJettyServer.class.getProtectionDomain();
			URL location = domain.getCodeSource().getLocation();

			WebAppContext webapp = new WebAppContext();
			webapp.setContextPath("/");
			webapp.setDescriptor(location.toExternalForm() + "/WEB-INF/web.xml");
			webapp.setResourceBase("src/main/webapp");
			webapp.setServer(server);
			webapp.setWar(location.toExternalForm());

			server.setHandler(webapp);
			server.start();
			server.join();
		} catch (Exception e) {
			LOGGER.fatal("Server will stop : an unexpected exception  occured", e);
		}
	}
}
