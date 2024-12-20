/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2029-07-20
 ******************************************************************************/


package mondrian.rolap;

import mondrian.rolap.sql.MemberChildrenConstraint;
import mondrian.rolap.sql.TupleConstraint;

import java.util.List;

/**
 * A <code>MemberCache</code> can retrieve members based upon their parent and
 * name.
 *
 * @author jhyde
 * @since 22 December, 2001
 */
interface MemberCache {
    /**
     * Creates a key with which to {@link #getMember(Object)} or
     * {@link #putMember(Object, RolapMember)} the
     * {@link RolapMember} with a given parent and key.
     *
     * @param parent Parent member
     * @param key Key of member within parent
     * @return key with which to address this member in the cache
     */
    Object makeKey(RolapMember parent, Object key);

    /**
     * Retrieves the {@link RolapMember} with a given key.
     *
     * @param key cache key, created by {@link #makeKey}
     * @return member with a given cache key
     */
    RolapMember getMember(Object key);

    /**
     * Retrieves the {@link RolapMember} with a given key.
     *
     * @param key cache key, created by {@link #makeKey}
     * @param mustCheckCacheStatus If {@code true}, do not check cache status
     * @return member with a given cache key
     */
    RolapMember getMember(Object key, boolean mustCheckCacheStatus);

    /**
     * Replaces the {@link RolapMember} with a given key and returns the
     * previous member if any.
     *
     * @param key cache key, created by {@link #makeKey}
     * @param member new member
     * @return Previous member with that key, or null.
     */
    Object putMember(Object key, RolapMember member);

    /**
     * Returns whether the cache supports removing selected items. If it does,
     * it is valid to call the {@link #removeMember(Object)} and
     * {@link #removeMemberAndDescendants(Object)} methods.
     *
     * <p>REVIEW: remove isMutable and move removeMember and
     * removeMemberAndDescendants to new interface MutableMemberCache
     *
     * @return true if the cache supports removing selected items.
     */
    boolean isMutable();

    /**
     * Removes the {@link RolapMember} with a given key from the cache.
     * Returns the previous member with that key, or null.
     * Optional operation: see {@link #isMutable}.
     *
     * @param key cache key, created by {@link #makeKey}
     * @return previous member with that key, or null
     */
    RolapMember removeMember(Object key);

    /**
     * Removes the designated {@link RolapMember} and all its descendants.
     * Returns the previous member with that key, or null.
     * Optional operation: see {@link #isMutable}.
     *
     * @param key cache key, created by {@link #makeKey}
     * @return previous member with that key, or null
     */
    RolapMember removeMemberAndDescendants(Object key);

    /**
     * Returns the children of <code>member</code> if they are currently in the
     * cache, otherwise returns null.
     *
     * <p>The children may be garbage collected as
     * soon as the returned list may be garbage collected.</p>
     *
     * @param parent the parent member
     * @param constraint the condition that was used when the members were
     *    fetched. May be null for all members (no constraint)
     * @return list of children, or null if not in cache
     */
    List<RolapMember> getChildrenFromCache(
        RolapMember parent,
        MemberChildrenConstraint constraint);

    /**
     * Returns the members of <code>level</code> if they are currently in the
     * cache, otherwise returns null.
     *
     * <p>The members may be garbage collected as soon as the
     * returned list may be garbage collected.</p>
     *
     * @param level the level whose members should be fetched
     * @param constraint the condition that was used when the members were
     *   fetched. May be null for all members (no constraint)
     * @return members of level, or null if not in cache
     */
    List<RolapMember> getLevelMembersFromCache(
        RolapLevel level,
        TupleConstraint constraint);

    /**
     * Registers that the children of <code>member</code> are
     * <code>children</code> (a list of {@link RolapMember}s).
     *
     * @param member the parent member
     * @param constraint the condition that was used when the members were
     *   fetched. May be null for all members (no constraint)
     * @param children list of children
     */
    void putChildren(
        RolapMember member,
        MemberChildrenConstraint constraint,
        List<RolapMember> children);

    /**
     * Registers that the children of <code>level</code> are
     * <code>children</code> (a list of {@link RolapMember}s).
     *
     * @param level the parent level
     * @param constraint the condition that was used when the members were
     *   fetched. May be null for all members (no constraint)
     * @param children list of children
     */
    void putChildren(
        RolapLevel level,
        TupleConstraint constraint,
        List<RolapMember> children);
}


// End MemberCache.java
