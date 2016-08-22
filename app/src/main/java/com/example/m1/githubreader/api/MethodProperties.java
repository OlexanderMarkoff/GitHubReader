package com.example.m1.githubreader.api;

/**
 * Created by Markov O on 22.08.16.
 */
@SuppressWarnings("DefaultFileTemplate")
public interface MethodProperties {


    String SCOPES = "scopes";    // array	A list of scopes that this authorization is in.
    String NOTE = "note";    //string	Required. A note to remind you what the OAuth token is for. Tokens not associated with a specific OAuth application (i.e. personal access tokens) must have a unique note.
    String NOTE_URL = "note_url";    //string	A URL to remind you what app the OAuth token is for.
    String CLIENT_ID = "client_id";    //string	The 20 character OAuth app client key for which to create the token.
    String CLIENT_SECRET = "client_secret";    //string	The 40 character OAuth app client secret for which to create the token.
    String FINGERPRINT = "fingerprint";    //string	A unique string to distinguish an authorization from others created for the same client ID and user.

}
