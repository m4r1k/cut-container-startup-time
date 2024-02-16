package com.medium.quick.pod.app;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class App 
{
    private static final Instant INITIALIZATION_TIME = Instant.ofEpochMilli(ManagementFactory.getRuntimeMXBean().getStartTime());

    private static final String projectId = "medium-quick-pod-414109";
    private static final String bucketName = "my-sample-bucket-414109";
    private static final String topicId = "my-sample-topic-414109";

    public static void main(String... args) throws IOException, InterruptedException {
        final Duration startupTime = Duration.between(INITIALIZATION_TIME, Instant.now());
        ListPubSubNotifications.listPubSubNotifications(bucketName);
        final Duration timeToFirstRequest = Duration.between(INITIALIZATION_TIME, Instant.now());
        PublishWithErrorHandlerExample.publishWithErrorHandlerExample(projectId, topicId);


        System.out.println("Startup time: " + startupTime.toMillis() + " ms, or " + TimeUnit.NANOSECONDS.toMicros(startupTime.toNanos()) + " microseconds");
        System.out.println("Time to finish first request: " + timeToFirstRequest.toMillis() + "ms");
        System.out.println("Shutting down. Total time elapsed: " + Duration.between(INITIALIZATION_TIME, Instant.now()).toMillis() + "ms");
    }
}
