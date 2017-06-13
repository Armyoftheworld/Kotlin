package com.army.kotlin

import com.google.gson.annotations.SerializedName

/**
 * Created by Army on 2017/06/11.
 */

class Resp {

    /**
     * id : 3432266
     * name : kotlin
     * full_name : JetBrains/kotlin
     * owner : {"login":"JetBrains","id":878437,"avatar_url":"https://avatars1.githubusercontent.com/u/878437?v=3","gravatar_id":"","url":"https://api.github.com/users/JetBrains","html_url":"https://github.com/JetBrains","followers_url":"https://api.github.com/users/JetBrains/followers","following_url":"https://api.github.com/users/JetBrains/following{/other_user}","gists_url":"https://api.github.com/users/JetBrains/gists{/gist_id}","starred_url":"https://api.github.com/users/JetBrains/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/JetBrains/subscriptions","organizations_url":"https://api.github.com/users/JetBrains/orgs","repos_url":"https://api.github.com/users/JetBrains/repos","events_url":"https://api.github.com/users/JetBrains/events{/privacy}","received_events_url":"https://api.github.com/users/JetBrains/received_events","type":"Organization","site_admin":false}
     * private : false
     * html_url : https://github.com/JetBrains/kotlin
     * description : The Kotlin Programming Language
     * fork : false
     * url : https://api.github.com/repos/JetBrains/kotlin
     * forks_url : https://api.github.com/repos/JetBrains/kotlin/forks
     * keys_url : https://api.github.com/repos/JetBrains/kotlin/keys{/key_id}
     * collaborators_url : https://api.github.com/repos/JetBrains/kotlin/collaborators{/collaborator}
     * teams_url : https://api.github.com/repos/JetBrains/kotlin/teams
     * hooks_url : https://api.github.com/repos/JetBrains/kotlin/hooks
     * issue_events_url : https://api.github.com/repos/JetBrains/kotlin/issues/events{/number}
     * events_url : https://api.github.com/repos/JetBrains/kotlin/events
     * assignees_url : https://api.github.com/repos/JetBrains/kotlin/assignees{/user}
     * branches_url : https://api.github.com/repos/JetBrains/kotlin/branches{/branch}
     * tags_url : https://api.github.com/repos/JetBrains/kotlin/tags
     * blobs_url : https://api.github.com/repos/JetBrains/kotlin/git/blobs{/sha}
     * git_tags_url : https://api.github.com/repos/JetBrains/kotlin/git/tags{/sha}
     * git_refs_url : https://api.github.com/repos/JetBrains/kotlin/git/refs{/sha}
     * trees_url : https://api.github.com/repos/JetBrains/kotlin/git/trees{/sha}
     * statuses_url : https://api.github.com/repos/JetBrains/kotlin/statuses/{sha}
     * languages_url : https://api.github.com/repos/JetBrains/kotlin/languages
     * stargazers_url : https://api.github.com/repos/JetBrains/kotlin/stargazers
     * contributors_url : https://api.github.com/repos/JetBrains/kotlin/contributors
     * subscribers_url : https://api.github.com/repos/JetBrains/kotlin/subscribers
     * subscription_url : https://api.github.com/repos/JetBrains/kotlin/subscription
     * commits_url : https://api.github.com/repos/JetBrains/kotlin/commits{/sha}
     * git_commits_url : https://api.github.com/repos/JetBrains/kotlin/git/commits{/sha}
     * comments_url : https://api.github.com/repos/JetBrains/kotlin/comments{/number}
     * issue_comment_url : https://api.github.com/repos/JetBrains/kotlin/issues/comments{/number}
     * contents_url : https://api.github.com/repos/JetBrains/kotlin/contents/{+path}
     * compare_url : https://api.github.com/repos/JetBrains/kotlin/compare/{base}...{head}
     * merges_url : https://api.github.com/repos/JetBrains/kotlin/merges
     * archive_url : https://api.github.com/repos/JetBrains/kotlin/{archive_format}{/ref}
     * downloads_url : https://api.github.com/repos/JetBrains/kotlin/downloads
     * issues_url : https://api.github.com/repos/JetBrains/kotlin/issues{/number}
     * pulls_url : https://api.github.com/repos/JetBrains/kotlin/pulls{/number}
     * milestones_url : https://api.github.com/repos/JetBrains/kotlin/milestones{/number}
     * notifications_url : https://api.github.com/repos/JetBrains/kotlin/notifications{?since,all,participating}
     * labels_url : https://api.github.com/repos/JetBrains/kotlin/labels{/name}
     * releases_url : https://api.github.com/repos/JetBrains/kotlin/releases{/id}
     * deployments_url : https://api.github.com/repos/JetBrains/kotlin/deployments
     * created_at : 2012-02-13T17:29:58Z
     * updated_at : 2017-06-11T07:46:10Z
     * pushed_at : 2017-06-11T05:44:32Z
     * git_url : git://github.com/JetBrains/kotlin.git
     * ssh_url : git@github.com:JetBrains/kotlin.git
     * clone_url : https://github.com/JetBrains/kotlin.git
     * svn_url : https://github.com/JetBrains/kotlin
     * homepage : http://kotlinlang.org/
     * size : 384433
     * stargazers_count : 14818
     * watchers_count : 14818
     * language : Java
     * has_issues : false
     * has_projects : true
     * has_downloads : true
     * has_wiki : false
     * has_pages : true
     * forks_count : 1411
     * mirror_url : null
     * open_issues_count : 33
     * forks : 1411
     * open_issues : 33
     * watchers : 14818
     * default_branch : master
     * score : 142.17339
     */

    var id: Int = 0
    var name: String? = null
    var full_name: String? = null
    var owner: OwnerBean? = null
    @SerializedName("private")
    var isPrivateX: Boolean = false
    var html_url: String? = null
    var description: String? = null
    var isFork: Boolean = false
    var url: String? = null
    var forks_url: String? = null
    var keys_url: String? = null
    var collaborators_url: String? = null
    var teams_url: String? = null
    var hooks_url: String? = null
    var issue_events_url: String? = null
    var events_url: String? = null
    var assignees_url: String? = null
    var branches_url: String? = null
    var tags_url: String? = null
    var blobs_url: String? = null
    var git_tags_url: String? = null
    var git_refs_url: String? = null
    var trees_url: String? = null
    var statuses_url: String? = null
    var languages_url: String? = null
    var stargazers_url: String? = null
    var contributors_url: String? = null
    var subscribers_url: String? = null
    var subscription_url: String? = null
    var commits_url: String? = null
    var git_commits_url: String? = null
    var comments_url: String? = null
    var issue_comment_url: String? = null
    var contents_url: String? = null
    var compare_url: String? = null
    var merges_url: String? = null
    var archive_url: String? = null
    var downloads_url: String? = null
    var issues_url: String? = null
    var pulls_url: String? = null
    var milestones_url: String? = null
    var notifications_url: String? = null
    var labels_url: String? = null
    var releases_url: String? = null
    var deployments_url: String? = null
    var created_at: String? = null
    var updated_at: String? = null
    var pushed_at: String? = null
    var git_url: String? = null
    var ssh_url: String? = null
    var clone_url: String? = null
    var svn_url: String? = null
    var homepage: String? = null
    var size: Int = 0
    var stargazers_count: Int = 0
    var watchers_count: Int = 0
    var language: String? = null
    var isHas_issues: Boolean = false
    var isHas_projects: Boolean = false
    var isHas_downloads: Boolean = false
    var isHas_wiki: Boolean = false
    var isHas_pages: Boolean = false
    var forks_count: Int = 0
    var mirror_url: Any? = null
    var open_issues_count: Int = 0
    var forks: Int = 0
    var open_issues: Int = 0
    var watchers: Int = 0
    var default_branch: String? = null
    var score: Double = 0.toDouble()

    class OwnerBean {
        /**
         * login : JetBrains
         * id : 878437
         * avatar_url : https://avatars1.githubusercontent.com/u/878437?v=3
         * gravatar_id :
         * url : https://api.github.com/users/JetBrains
         * html_url : https://github.com/JetBrains
         * followers_url : https://api.github.com/users/JetBrains/followers
         * following_url : https://api.github.com/users/JetBrains/following{/other_user}
         * gists_url : https://api.github.com/users/JetBrains/gists{/gist_id}
         * starred_url : https://api.github.com/users/JetBrains/starred{/owner}{/repo}
         * subscriptions_url : https://api.github.com/users/JetBrains/subscriptions
         * organizations_url : https://api.github.com/users/JetBrains/orgs
         * repos_url : https://api.github.com/users/JetBrains/repos
         * events_url : https://api.github.com/users/JetBrains/events{/privacy}
         * received_events_url : https://api.github.com/users/JetBrains/received_events
         * type : Organization
         * site_admin : false
         */

        var login: String? = null
        var id: Int = 0
        var avatar_url: String? = null
        var gravatar_id: String? = null
        var url: String? = null
        var html_url: String? = null
        var followers_url: String? = null
        var following_url: String? = null
        var gists_url: String? = null
        var starred_url: String? = null
        var subscriptions_url: String? = null
        var organizations_url: String? = null
        var repos_url: String? = null
        var events_url: String? = null
        var received_events_url: String? = null
        var type: String? = null
        var isSite_admin: Boolean = false
    }
}
