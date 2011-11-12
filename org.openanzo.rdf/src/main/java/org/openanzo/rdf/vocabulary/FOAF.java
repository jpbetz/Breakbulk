/*******************************************************************************
 * Copyright (c) 2007 Cambridge Semantics Incorporated.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cambridge Semantics Incorporated
 *******************************************************************************/
package org.openanzo.rdf.vocabulary;

import org.openanzo.rdf.MemURI;
import org.openanzo.rdf.URI;

/**
 * Vocabulary for Friend of a Friend (FOAF).
 * 
 * @author Joe Betz <jpbetz@cambridgesemantics.com>
 * 
 */
public class FOAF {
    protected static URI createProperty(String localName) {
        return MemURI.create(NAMESPACE + localName);
    }

    /** Version of foaf */
    public static final String VERSION                 = "0.1";

    /** Namespace for FOAF 0.1. */
    public static final String NAMESPACE               = "http://xmlns.com/foaf/0.1/";

    /** http://xmlns.com/foaf/0.1/Person */
    public static final URI    Person                  = createProperty("Person");

    /** http://xmlns.com/foaf/0.1/Document */
    public static final URI    Document                = createProperty("Document");

    /** http://xmlns.com/foaf/0.1/Organization */
    public static final URI    Organization            = createProperty("Organization");

    /** http://xmlns.com/foaf/0.1/Group */
    public static final URI    Group                   = createProperty("Group");

    /** http://xmlns.com/foaf/0.1/Agent */
    public static final URI    Agent                   = createProperty("Agent");

    /** http://xmlns.com/foaf/0.1/Project */
    public static final URI    Project                 = createProperty("Project");

    /** http://xmlns.com/foaf/0.1/Image */
    public static final URI    Image                   = createProperty("Image");

    /** http://xmlns.com/foaf/0.1/PersonalProfileDocument */
    public static final URI    PersonalProfileDocument = createProperty("PersonalProfileDocument");

    /** http://xmlns.com/foaf/0.1/OnlineAccount */
    public static final URI    OnlineAccount           = createProperty("OnlineAccount");

    /** http://xmlns.com/foaf/0.1/OnlineGamingAccount */
    public static final URI    OnlineGamingAccount     = createProperty("OnlineGamingAccount");

    /** http://xmlns.com/foaf/0.1/OnlineEcommerceAccount */
    public static final URI    OnlineEcommerceAccount  = createProperty("OnlineEcommerceAccount");

    /** http://xmlns.com/foaf/0.1/OnlineChatAccount */
    public static final URI    OnlineChatAccount       = createProperty("OnlineChatAccount");

    /** http://xmlns.com/foaf/0.1/mbox */
    public static final URI    mbox                    = createProperty("mbox");

    /** http://xmlns.com/foaf/0.1/mbox_sha1sum */
    public static final URI    mbox_sha1sum            = createProperty("mbox_sha1sum");

    /** http://xmlns.com/foaf/0.1/gender */
    public static final URI    gender                  = createProperty("gender");

    /** http://xmlns.com/foaf/0.1/geekcode */
    public static final URI    geekcode                = createProperty("geekcode");

    /** http://xmlns.com/foaf/0.1/dnaChecksum */
    public static final URI    dnaChecksum             = createProperty("dnaChecksum");

    /** http://xmlns.com/foaf/0.1/sha1 */
    public static final URI    sha1                    = createProperty("sha1");

    /** http://xmlns.com/foaf/0.1/based_near */
    public static final URI    based_near              = createProperty("based_near");

    /** http://xmlns.com/foaf/0.1/title */
    public static final URI    title                   = createProperty("title");

    /** http://xmlns.com/foaf/0.1/nick */
    public static final URI    nick                    = createProperty("nick");

    /** http://xmlns.com/foaf/0.1/jabberID */
    public static final URI    jabberID                = createProperty("jabberID");

    /** http://xmlns.com/foaf/0.1/aimChatID */
    public static final URI    aimChatID               = createProperty("aimChatID");

    /** http://xmlns.com/foaf/0.1/icqChatID */
    public static final URI    icqChatID               = createProperty("icqChatID");

    /** http://xmlns.com/foaf/0.1/yahooChatID */
    public static final URI    yahooChatID             = createProperty("yahooChatID");

    /** http://xmlns.com/foaf/0.1/msnChatID */
    public static final URI    msnChatID               = createProperty("msnChatID");

    /** http://xmlns.com/foaf/0.1/name */
    public static final URI    name                    = createProperty("name");

    /** http://xmlns.com/foaf/0.1/firstName */
    public static final URI    firstName               = createProperty("firstName");

    /** http://xmlns.com/foaf/0.1/givenname */
    public static final URI    givenname               = createProperty("givenname");

    /** http://xmlns.com/foaf/0.1/surname */
    public static final URI    surname                 = createProperty("surname");

    /** http://xmlns.com/foaf/0.1/family_name */
    public static final URI    family_name             = createProperty("family_name");

    /** http://xmlns.com/foaf/0.1/phone */
    public static final URI    phone                   = createProperty("phone");

    /** http://xmlns.com/foaf/0.1/homepage */
    public static final URI    homepage                = createProperty("homepage");

    /** http://xmlns.com/foaf/0.1/weblog */
    public static final URI    weblog                  = createProperty("weblog");

    /** http://xmlns.com/foaf/0.1/openid */
    public static final URI    openid                  = createProperty("openid");

    /** http://xmlns.com/foaf/0.1/tipjar */
    public static final URI    tipjar                  = createProperty("tipjar");

    /** http://xmlns.com/foaf/0.1/plan */
    public static final URI    plan                    = createProperty("plan");

    /** http://xmlns.com/foaf/0.1/made */
    public static final URI    made                    = createProperty("made");

    /** http://xmlns.com/foaf/0.1/maker */
    public static final URI    maker                   = createProperty("maker");

    /** http://xmlns.com/foaf/0.1/img */
    public static final URI    img                     = createProperty("img");

    /** http://xmlns.com/foaf/0.1/depiction */
    public static final URI    depiction               = createProperty("depiction");

    /** http://xmlns.com/foaf/0.1/depicts */
    public static final URI    depicts                 = createProperty("depicts");

    /** http://xmlns.com/foaf/0.1/thumbnail */
    public static final URI    thumbnail               = createProperty("thumbnail");

    /** http://xmlns.com/foaf/0.1/myersBriggs */
    public static final URI    myersBriggs             = createProperty("myersBriggs");

    /** http://xmlns.com/foaf/0.1/workplaceHomepage */
    public static final URI    workplaceHomepage       = createProperty("workplaceHomepage");

    /** http://xmlns.com/foaf/0.1/workInfoHomepage */
    public static final URI    workInfoHomepage        = createProperty("workInfoHomepage");

    /** http://xmlns.com/foaf/0.1/schoolHomepage */
    public static final URI    schoolHomepage          = createProperty("schoolHomepage");

    /** http://xmlns.com/foaf/0.1/knows */
    public static final URI    knows                   = createProperty("knows");

    /** http://xmlns.com/foaf/0.1/interest */
    public static final URI    interest                = createProperty("interest");

    /** http://xmlns.com/foaf/0.1/topic_interest */
    public static final URI    topic_interest          = createProperty("topic_interest");

    /** http://xmlns.com/foaf/0.1/publications */
    public static final URI    publications            = createProperty("publications");

    /** http://xmlns.com/foaf/0.1/currentProject */
    public static final URI    currentProject          = createProperty("currentProject");

    /** http://xmlns.com/foaf/0.1/pastProject */
    public static final URI    pastProject             = createProperty("pastProject");

    /** http://xmlns.com/foaf/0.1/fundedBy */
    public static final URI    fundedBy                = createProperty("fundedBy");

    /** http://xmlns.com/foaf/0.1/logo */
    public static final URI    logo                    = createProperty("logo");

    /** http://xmlns.com/foaf/0.1/topic */
    public static final URI    topic                   = createProperty("topic");

    /** http://xmlns.com/foaf/0.1/primaryTopic */
    public static final URI    primaryTopic            = createProperty("primaryTopic");

    /** http://xmlns.com/foaf/0.1/isPrimaryTopicOf */
    public static final URI    isPrimaryTopicOf        = createProperty("isPrimaryTopicOf");

    /** http://xmlns.com/foaf/0.1/page */
    public static final URI    page                    = createProperty("page");

    /** http://xmlns.com/foaf/0.1/theme */
    public static final URI    theme                   = createProperty("theme");

    /** http://xmlns.com/foaf/0.1/holdsAccount */
    public static final URI    holdsAccount            = createProperty("holdsAccount");

    /** http://xmlns.com/foaf/0.1/accountServiceHomepage */
    public static final URI    accountServiceHomepage  = createProperty("accountServiceHomepage");

    /** http://xmlns.com/foaf/0.1/accountName */
    public static final URI    accountName             = createProperty("accountName");

    /** http://xmlns.com/foaf/0.1/member */
    public static final URI    member                  = createProperty("member");

    /** http://xmlns.com/foaf/0.1/membershipClass */
    public static final URI    membershipClass         = createProperty("membershipClass");

    /** http://xmlns.com/foaf/0.1/birthday */
    public static final URI    birthday                = createProperty("birthday");

    /** http://xmlns.com/foaf/0.1/age */
    public static final URI    age                     = createProperty("age");

}
