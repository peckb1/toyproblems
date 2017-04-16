package com.github.peckb1.topcoder.practice.easy;

import java.util.Arrays;

/**
 * In many computer systems and networks, different users are granted different levels of access to different resources.
 * In this case, you are given a rights, indicating the privilege level of each user to use some system resource.
 * You are also given a minPermission, which is the minimum permission a user must have to use this resource.
 * <p>
 * You are to return a indicating which users can and cannot access this resource.
 * Each character in the return value corresponds to the element of users with the same index.
 * 'A' indicates the user is allowed access, while 'D' indicates the user is denied access.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AccessLevel {

    public String canAccess(int[] rights, int minPermission) {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(rights).forEach(accessLevel -> {
            if (accessLevel >= minPermission) {
                sb.append("A");
            } else {
                sb.append("D");
            }
        });

        return sb.toString();
    }

}
