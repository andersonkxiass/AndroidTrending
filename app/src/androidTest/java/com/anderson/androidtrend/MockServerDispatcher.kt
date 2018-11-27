package com.anderson.androidtrend

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.io.File

internal class MockServerDispatcher {

    /**
     * Return ok response from mock server
     */
    internal inner class RequestDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {

            return when {
                request.path.contains("/search/repositories") ->
                    MockResponse()
                        .setResponseCode(200)
                        .setBody("{\n" +
                                "  \"total_count\": 498032,\n" +
                                "  \"incomplete_results\": false,\n" +
                                "  \"items\": [\n" +
                                "    {\n" +
                                "      \"id\": 892275,\n" +
                                "      \"node_id\": \"MDEwOlJlcG9zaXRvcnk4OTIyNzU=\",\n" +
                                "      \"name\": \"retrofit\",\n" +
                                "      \"full_name\": \"square/retrofit\",\n" +
                                "      \"private\": false,\n" +
                                "      \"owner\": {\n" +
                                "        \"login\": \"square\",\n" +
                                "        \"id\": 82592,\n" +
                                "        \"node_id\": \"MDEyOk9yZ2FuaXphdGlvbjgyNTky\",\n" +
                                "        \"avatar_url\": \"https://avatars0.githubusercontent.com/u/82592?v=4\",\n" +
                                "        \"gravatar_id\": \"\",\n" +
                                "        \"url\": \"https://api.github.com/users/square\",\n" +
                                "        \"html_url\": \"https://github.com/square\",\n" +
                                "        \"followers_url\": \"https://api.github.com/users/square/followers\",\n" +
                                "        \"following_url\": \"https://api.github.com/users/square/following{/other_user}\",\n" +
                                "        \"gists_url\": \"https://api.github.com/users/square/gists{/gist_id}\",\n" +
                                "        \"starred_url\": \"https://api.github.com/users/square/starred{/owner}{/repo}\",\n" +
                                "        \"subscriptions_url\": \"https://api.github.com/users/square/subscriptions\",\n" +
                                "        \"organizations_url\": \"https://api.github.com/users/square/orgs\",\n" +
                                "        \"repos_url\": \"https://api.github.com/users/square/repos\",\n" +
                                "        \"events_url\": \"https://api.github.com/users/square/events{/privacy}\",\n" +
                                "        \"received_events_url\": \"https://api.github.com/users/square/received_events\",\n" +
                                "        \"type\": \"Organization\",\n" +
                                "        \"site_admin\": false\n" +
                                "      },\n" +
                                "      \"html_url\": \"https://github.com/square/retrofit\",\n" +
                                "      \"description\": \"Type-safe HTTP client for Android and Java by Square, Inc.\",\n" +
                                "      \"fork\": false,\n" +
                                "      \"url\": \"https://api.github.com/repos/square/retrofit\",\n" +
                                "      \"forks_url\": \"https://api.github.com/repos/square/retrofit/forks\",\n" +
                                "      \"keys_url\": \"https://api.github.com/repos/square/retrofit/keys{/key_id}\",\n" +
                                "      \"collaborators_url\": \"https://api.github.com/repos/square/retrofit/collaborators{/collaborator}\",\n" +
                                "      \"teams_url\": \"https://api.github.com/repos/square/retrofit/teams\",\n" +
                                "      \"hooks_url\": \"https://api.github.com/repos/square/retrofit/hooks\",\n" +
                                "      \"issue_events_url\": \"https://api.github.com/repos/square/retrofit/issues/events{/number}\",\n" +
                                "      \"events_url\": \"https://api.github.com/repos/square/retrofit/events\",\n" +
                                "      \"assignees_url\": \"https://api.github.com/repos/square/retrofit/assignees{/user}\",\n" +
                                "      \"branches_url\": \"https://api.github.com/repos/square/retrofit/branches{/branch}\",\n" +
                                "      \"tags_url\": \"https://api.github.com/repos/square/retrofit/tags\",\n" +
                                "      \"blobs_url\": \"https://api.github.com/repos/square/retrofit/git/blobs{/sha}\",\n" +
                                "      \"git_tags_url\": \"https://api.github.com/repos/square/retrofit/git/tags{/sha}\",\n" +
                                "      \"git_refs_url\": \"https://api.github.com/repos/square/retrofit/git/refs{/sha}\",\n" +
                                "      \"trees_url\": \"https://api.github.com/repos/square/retrofit/git/trees{/sha}\",\n" +
                                "      \"statuses_url\": \"https://api.github.com/repos/square/retrofit/statuses/{sha}\",\n" +
                                "      \"languages_url\": \"https://api.github.com/repos/square/retrofit/languages\",\n" +
                                "      \"stargazers_url\": \"https://api.github.com/repos/square/retrofit/stargazers\",\n" +
                                "      \"contributors_url\": \"https://api.github.com/repos/square/retrofit/contributors\",\n" +
                                "      \"subscribers_url\": \"https://api.github.com/repos/square/retrofit/subscribers\",\n" +
                                "      \"subscription_url\": \"https://api.github.com/repos/square/retrofit/subscription\",\n" +
                                "      \"commits_url\": \"https://api.github.com/repos/square/retrofit/commits{/sha}\",\n" +
                                "      \"git_commits_url\": \"https://api.github.com/repos/square/retrofit/git/commits{/sha}\",\n" +
                                "      \"comments_url\": \"https://api.github.com/repos/square/retrofit/comments{/number}\",\n" +
                                "      \"issue_comment_url\": \"https://api.github.com/repos/square/retrofit/issues/comments{/number}\",\n" +
                                "      \"contents_url\": \"https://api.github.com/repos/square/retrofit/contents/{+path}\",\n" +
                                "      \"compare_url\": \"https://api.github.com/repos/square/retrofit/compare/{base}...{head}\",\n" +
                                "      \"merges_url\": \"https://api.github.com/repos/square/retrofit/merges\",\n" +
                                "      \"archive_url\": \"https://api.github.com/repos/square/retrofit/{archive_format}{/ref}\",\n" +
                                "      \"downloads_url\": \"https://api.github.com/repos/square/retrofit/downloads\",\n" +
                                "      \"issues_url\": \"https://api.github.com/repos/square/retrofit/issues{/number}\",\n" +
                                "      \"pulls_url\": \"https://api.github.com/repos/square/retrofit/pulls{/number}\",\n" +
                                "      \"milestones_url\": \"https://api.github.com/repos/square/retrofit/milestones{/number}\",\n" +
                                "      \"notifications_url\": \"https://api.github.com/repos/square/retrofit/notifications{?since,all,participating}\",\n" +
                                "      \"labels_url\": \"https://api.github.com/repos/square/retrofit/labels{/name}\",\n" +
                                "      \"releases_url\": \"https://api.github.com/repos/square/retrofit/releases{/id}\",\n" +
                                "      \"deployments_url\": \"https://api.github.com/repos/square/retrofit/deployments\",\n" +
                                "      \"created_at\": \"2010-09-06T21:39:43Z\",\n" +
                                "      \"updated_at\": \"2018-11-26T12:44:20Z\",\n" +
                                "      \"pushed_at\": \"2018-11-26T14:17:17Z\",\n" +
                                "      \"git_url\": \"git://github.com/square/retrofit.git\",\n" +
                                "      \"ssh_url\": \"git@github.com:square/retrofit.git\",\n" +
                                "      \"clone_url\": \"https://github.com/square/retrofit.git\",\n" +
                                "      \"svn_url\": \"https://github.com/square/retrofit\",\n" +
                                "      \"homepage\": \"http://square.github.io/retrofit/\",\n" +
                                "      \"size\": 4872,\n" +
                                "      \"stargazers_count\": 30439,\n" +
                                "      \"watchers_count\": 30439,\n" +
                                "      \"language\": \"Java\",\n" +
                                "      \"has_issues\": true,\n" +
                                "      \"has_projects\": false,\n" +
                                "      \"has_downloads\": true,\n" +
                                "      \"has_wiki\": true,\n" +
                                "      \"has_pages\": true,\n" +
                                "      \"forks_count\": 5791,\n" +
                                "      \"mirror_url\": null,\n" +
                                "      \"archived\": false,\n" +
                                "      \"open_issues_count\": 72,\n" +
                                "      \"license\": {\n" +
                                "        \"key\": \"apache-2.0\",\n" +
                                "        \"name\": \"Apache License 2.0\",\n" +
                                "        \"spdx_id\": \"Apache-2.0\",\n" +
                                "        \"url\": \"https://api.github.com/licenses/apache-2.0\",\n" +
                                "        \"node_id\": \"MDc6TGljZW5zZTI=\"\n" +
                                "      },\n" +
                                "      \"forks\": 5791,\n" +
                                "      \"open_issues\": 72,\n" +
                                "      \"watchers\": 30439,\n" +
                                "      \"default_branch\": \"master\",\n" +
                                "      \"score\": 40.50301\n" +
                                "    },\n" +
                                "    {\n" +
                                "      \"id\": 5152285,\n" +
                                "      \"node_id\": \"MDEwOlJlcG9zaXRvcnk1MTUyMjg1\",\n" +
                                "      \"name\": \"okhttp\",\n" +
                                "      \"full_name\": \"square/okhttp\",\n" +
                                "      \"private\": false,\n" +
                                "      \"owner\": {\n" +
                                "        \"login\": \"square\",\n" +
                                "        \"id\": 82592,\n" +
                                "        \"node_id\": \"MDEyOk9yZ2FuaXphdGlvbjgyNTky\",\n" +
                                "        \"avatar_url\": \"https://avatars0.githubusercontent.com/u/82592?v=4\",\n" +
                                "        \"gravatar_id\": \"\",\n" +
                                "        \"url\": \"https://api.github.com/users/square\",\n" +
                                "        \"html_url\": \"https://github.com/square\",\n" +
                                "        \"followers_url\": \"https://api.github.com/users/square/followers\",\n" +
                                "        \"following_url\": \"https://api.github.com/users/square/following{/other_user}\",\n" +
                                "        \"gists_url\": \"https://api.github.com/users/square/gists{/gist_id}\",\n" +
                                "        \"starred_url\": \"https://api.github.com/users/square/starred{/owner}{/repo}\",\n" +
                                "        \"subscriptions_url\": \"https://api.github.com/users/square/subscriptions\",\n" +
                                "        \"organizations_url\": \"https://api.github.com/users/square/orgs\",\n" +
                                "        \"repos_url\": \"https://api.github.com/users/square/repos\",\n" +
                                "        \"events_url\": \"https://api.github.com/users/square/events{/privacy}\",\n" +
                                "        \"received_events_url\": \"https://api.github.com/users/square/received_events\",\n" +
                                "        \"type\": \"Organization\",\n" +
                                "        \"site_admin\": false\n" +
                                "      },\n" +
                                "      \"html_url\": \"https://github.com/square/okhttp\",\n" +
                                "      \"description\": \"An HTTP+HTTP/2 client for Android and Java applications.\",\n" +
                                "      \"fork\": false,\n" +
                                "      \"url\": \"https://api.github.com/repos/square/okhttp\",\n" +
                                "      \"forks_url\": \"https://api.github.com/repos/square/okhttp/forks\",\n" +
                                "      \"keys_url\": \"https://api.github.com/repos/square/okhttp/keys{/key_id}\",\n" +
                                "      \"collaborators_url\": \"https://api.github.com/repos/square/okhttp/collaborators{/collaborator}\",\n" +
                                "      \"teams_url\": \"https://api.github.com/repos/square/okhttp/teams\",\n" +
                                "      \"hooks_url\": \"https://api.github.com/repos/square/okhttp/hooks\",\n" +
                                "      \"issue_events_url\": \"https://api.github.com/repos/square/okhttp/issues/events{/number}\",\n" +
                                "      \"events_url\": \"https://api.github.com/repos/square/okhttp/events\",\n" +
                                "      \"assignees_url\": \"https://api.github.com/repos/square/okhttp/assignees{/user}\",\n" +
                                "      \"branches_url\": \"https://api.github.com/repos/square/okhttp/branches{/branch}\",\n" +
                                "      \"tags_url\": \"https://api.github.com/repos/square/okhttp/tags\",\n" +
                                "      \"blobs_url\": \"https://api.github.com/repos/square/okhttp/git/blobs{/sha}\",\n" +
                                "      \"git_tags_url\": \"https://api.github.com/repos/square/okhttp/git/tags{/sha}\",\n" +
                                "      \"git_refs_url\": \"https://api.github.com/repos/square/okhttp/git/refs{/sha}\",\n" +
                                "      \"trees_url\": \"https://api.github.com/repos/square/okhttp/git/trees{/sha}\",\n" +
                                "      \"statuses_url\": \"https://api.github.com/repos/square/okhttp/statuses/{sha}\",\n" +
                                "      \"languages_url\": \"https://api.github.com/repos/square/okhttp/languages\",\n" +
                                "      \"stargazers_url\": \"https://api.github.com/repos/square/okhttp/stargazers\",\n" +
                                "      \"contributors_url\": \"https://api.github.com/repos/square/okhttp/contributors\",\n" +
                                "      \"subscribers_url\": \"https://api.github.com/repos/square/okhttp/subscribers\",\n" +
                                "      \"subscription_url\": \"https://api.github.com/repos/square/okhttp/subscription\",\n" +
                                "      \"commits_url\": \"https://api.github.com/repos/square/okhttp/commits{/sha}\",\n" +
                                "      \"git_commits_url\": \"https://api.github.com/repos/square/okhttp/git/commits{/sha}\",\n" +
                                "      \"comments_url\": \"https://api.github.com/repos/square/okhttp/comments{/number}\",\n" +
                                "      \"issue_comment_url\": \"https://api.github.com/repos/square/okhttp/issues/comments{/number}\",\n" +
                                "      \"contents_url\": \"https://api.github.com/repos/square/okhttp/contents/{+path}\",\n" +
                                "      \"compare_url\": \"https://api.github.com/repos/square/okhttp/compare/{base}...{head}\",\n" +
                                "      \"merges_url\": \"https://api.github.com/repos/square/okhttp/merges\",\n" +
                                "      \"archive_url\": \"https://api.github.com/repos/square/okhttp/{archive_format}{/ref}\",\n" +
                                "      \"downloads_url\": \"https://api.github.com/repos/square/okhttp/downloads\",\n" +
                                "      \"issues_url\": \"https://api.github.com/repos/square/okhttp/issues{/number}\",\n" +
                                "      \"pulls_url\": \"https://api.github.com/repos/square/okhttp/pulls{/number}\",\n" +
                                "      \"milestones_url\": \"https://api.github.com/repos/square/okhttp/milestones{/number}\",\n" +
                                "      \"notifications_url\": \"https://api.github.com/repos/square/okhttp/notifications{?since,all,participating}\",\n" +
                                "      \"labels_url\": \"https://api.github.com/repos/square/okhttp/labels{/name}\",\n" +
                                "      \"releases_url\": \"https://api.github.com/repos/square/okhttp/releases{/id}\",\n" +
                                "      \"deployments_url\": \"https://api.github.com/repos/square/okhttp/deployments\",\n" +
                                "      \"created_at\": \"2012-07-23T13:42:55Z\",\n" +
                                "      \"updated_at\": \"2018-11-26T18:31:26Z\",\n" +
                                "      \"pushed_at\": \"2018-11-26T12:14:12Z\",\n" +
                                "      \"git_url\": \"git://github.com/square/okhttp.git\",\n" +
                                "      \"ssh_url\": \"git@github.com:square/okhttp.git\",\n" +
                                "      \"clone_url\": \"https://github.com/square/okhttp.git\",\n" +
                                "      \"svn_url\": \"https://github.com/square/okhttp\",\n" +
                                "      \"homepage\": \"http://square.github.io/okhttp/\",\n" +
                                "      \"size\": 18354,\n" +
                                "      \"stargazers_count\": 29796,\n" +
                                "      \"watchers_count\": 29796,\n" +
                                "      \"language\": \"Java\",\n" +
                                "      \"has_issues\": true,\n" +
                                "      \"has_projects\": false,\n" +
                                "      \"has_downloads\": true,\n" +
                                "      \"has_wiki\": true,\n" +
                                "      \"has_pages\": true,\n" +
                                "      \"forks_count\": 6778,\n" +
                                "      \"mirror_url\": null,\n" +
                                "      \"archived\": false,\n" +
                                "      \"open_issues_count\": 171,\n" +
                                "      \"license\": {\n" +
                                "        \"key\": \"apache-2.0\",\n" +
                                "        \"name\": \"Apache License 2.0\",\n" +
                                "        \"spdx_id\": \"Apache-2.0\",\n" +
                                "        \"url\": \"https://api.github.com/licenses/apache-2.0\",\n" +
                                "        \"node_id\": \"MDc6TGljZW5zZTI=\"\n" +
                                "      },\n" +
                                "      \"forks\": 6778,\n" +
                                "      \"open_issues\": 171,\n" +
                                "      \"watchers\": 29796,\n" +
                                "      \"default_branch\": \"master\",\n" +
                                "      \"score\": 50.287193\n" +
                                "    },\n" +
                                "    {\n" +
                                "      \"id\": 19148949,\n" +
                                "      \"node_id\": \"MDEwOlJlcG9zaXRvcnkxOTE0ODk0OQ==\",\n" +
                                "      \"name\": \"MPAndroidChart\",\n" +
                                "      \"full_name\": \"PhilJay/MPAndroidChart\",\n" +
                                "      \"private\": false,\n" +
                                "      \"owner\": {\n" +
                                "        \"login\": \"PhilJay\",\n" +
                                "        \"id\": 6759734,\n" +
                                "        \"node_id\": \"MDQ6VXNlcjY3NTk3MzQ=\",\n" +
                                "        \"avatar_url\": \"https://avatars1.githubusercontent.com/u/6759734?v=4\",\n" +
                                "        \"gravatar_id\": \"\",\n" +
                                "        \"url\": \"https://api.github.com/users/PhilJay\",\n" +
                                "        \"html_url\": \"https://github.com/PhilJay\",\n" +
                                "        \"followers_url\": \"https://api.github.com/users/PhilJay/followers\",\n" +
                                "        \"following_url\": \"https://api.github.com/users/PhilJay/following{/other_user}\",\n" +
                                "        \"gists_url\": \"https://api.github.com/users/PhilJay/gists{/gist_id}\",\n" +
                                "        \"starred_url\": \"https://api.github.com/users/PhilJay/starred{/owner}{/repo}\",\n" +
                                "        \"subscriptions_url\": \"https://api.github.com/users/PhilJay/subscriptions\",\n" +
                                "        \"organizations_url\": \"https://api.github.com/users/PhilJay/orgs\",\n" +
                                "        \"repos_url\": \"https://api.github.com/users/PhilJay/repos\",\n" +
                                "        \"events_url\": \"https://api.github.com/users/PhilJay/events{/privacy}\",\n" +
                                "        \"received_events_url\": \"https://api.github.com/users/PhilJay/received_events\",\n" +
                                "        \"type\": \"User\",\n" +
                                "        \"site_admin\": false\n" +
                                "      },\n" +
                                "      \"html_url\": \"https://github.com/PhilJay/MPAndroidChart\",\n" +
                                "      \"description\": \"A powerful \uD83D\uDE80 Android chart view / graph view library, supporting line- bar- pie- radar- bubble- and candlestick charts as well as scaling, dragging and animations.\",\n" +
                                "      \"fork\": false,\n" +
                                "      \"url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart\",\n" +
                                "      \"forks_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/forks\",\n" +
                                "      \"keys_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/keys{/key_id}\",\n" +
                                "      \"collaborators_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/collaborators{/collaborator}\",\n" +
                                "      \"teams_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/teams\",\n" +
                                "      \"hooks_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/hooks\",\n" +
                                "      \"issue_events_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/issues/events{/number}\",\n" +
                                "      \"events_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/events\",\n" +
                                "      \"assignees_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/assignees{/user}\",\n" +
                                "      \"branches_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/branches{/branch}\",\n" +
                                "      \"tags_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/tags\",\n" +
                                "      \"blobs_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/git/blobs{/sha}\",\n" +
                                "      \"git_tags_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/git/tags{/sha}\",\n" +
                                "      \"git_refs_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/git/refs{/sha}\",\n" +
                                "      \"trees_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/git/trees{/sha}\",\n" +
                                "      \"statuses_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/statuses/{sha}\",\n" +
                                "      \"languages_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/languages\",\n" +
                                "      \"stargazers_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/stargazers\",\n" +
                                "      \"contributors_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/contributors\",\n" +
                                "      \"subscribers_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/subscribers\",\n" +
                                "      \"subscription_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/subscription\",\n" +
                                "      \"commits_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/commits{/sha}\",\n" +
                                "      \"git_commits_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/git/commits{/sha}\",\n" +
                                "      \"comments_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/comments{/number}\",\n" +
                                "      \"issue_comment_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/issues/comments{/number}\",\n" +
                                "      \"contents_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/contents/{+path}\",\n" +
                                "      \"compare_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/compare/{base}...{head}\",\n" +
                                "      \"merges_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/merges\",\n" +
                                "      \"archive_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/{archive_format}{/ref}\",\n" +
                                "      \"downloads_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/downloads\",\n" +
                                "      \"issues_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/issues{/number}\",\n" +
                                "      \"pulls_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/pulls{/number}\",\n" +
                                "      \"milestones_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/milestones{/number}\",\n" +
                                "      \"notifications_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/notifications{?since,all,participating}\",\n" +
                                "      \"labels_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/labels{/name}\",\n" +
                                "      \"releases_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/releases{/id}\",\n" +
                                "      \"deployments_url\": \"https://api.github.com/repos/PhilJay/MPAndroidChart/deployments\",\n" +
                                "      \"created_at\": \"2014-04-25T14:29:47Z\",\n" +
                                "      \"updated_at\": \"2018-11-26T15:11:39Z\",\n" +
                                "      \"pushed_at\": \"2018-11-22T04:41:34Z\",\n" +
                                "      \"git_url\": \"git://github.com/PhilJay/MPAndroidChart.git\",\n" +
                                "      \"ssh_url\": \"git@github.com:PhilJay/MPAndroidChart.git\",\n" +
                                "      \"clone_url\": \"https://github.com/PhilJay/MPAndroidChart.git\",\n" +
                                "      \"svn_url\": \"https://github.com/PhilJay/MPAndroidChart\",\n" +
                                "      \"homepage\": \"\",\n" +
                                "      \"size\": 21185,\n" +
                                "      \"stargazers_count\": 24997,\n" +
                                "      \"watchers_count\": 24997,\n" +
                                "      \"language\": \"Java\",\n" +
                                "      \"has_issues\": true,\n" +
                                "      \"has_projects\": true,\n" +
                                "      \"has_downloads\": true,\n" +
                                "      \"has_wiki\": true,\n" +
                                "      \"has_pages\": false,\n" +
                                "      \"forks_count\": 6677,\n" +
                                "      \"mirror_url\": null,\n" +
                                "      \"archived\": false,\n" +
                                "      \"open_issues_count\": 1300,\n" +
                                "      \"license\": {\n" +
                                "        \"key\": \"apache-2.0\",\n" +
                                "        \"name\": \"Apache License 2.0\",\n" +
                                "        \"spdx_id\": \"Apache-2.0\",\n" +
                                "        \"url\": \"https://api.github.com/licenses/apache-2.0\",\n" +
                                "        \"node_id\": \"MDc6TGljZW5zZTI=\"\n" +
                                "      },\n" +
                                "      \"forks\": 6677,\n" +
                                "      \"open_issues\": 1300,\n" +
                                "      \"watchers\": 24997,\n" +
                                "      \"default_branch\": \"master\",\n" +
                                "      \"score\": 50.906322\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}")

                request.path == "repos/{owner}/{project}/contributors" ->
                    MockResponse()
                        .setResponseCode(200)
                        .setBody("{codes:FakeCode}")
                else -> MockResponse().setResponseCode(404)
            }
        }
    }

    /**
     * Return error response from mock server
     */
    internal inner class ErrorDispatcher : Dispatcher() {

        override fun dispatch(request: RecordedRequest): MockResponse {
            return MockResponse().setResponseCode(400)
        }
    }

    private fun getJson(path : String) : String {
        val uri = MockServerDispatcher::class.java.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
}