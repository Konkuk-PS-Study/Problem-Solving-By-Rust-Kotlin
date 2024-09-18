use std::{borrow::{Borrow, BorrowMut}, cmp::Ordering};

fn main() {

    let l1 = Some(Box::new(ListNode::new(9)));
    let l2 = Some(Box::new(ListNode::new(8)));

    let result = Solution::add_two_numbers(l1, l2);

    println!("{:?}", result);
}

struct Solution;

impl Solution {
    pub fn add_two_numbers(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut ret: Option<Box<ListNode>> = None;
        let mut prev_node_next: &mut Option<Box<ListNode>> = &mut ret;

        let mut now_l1 = l1.clone();
        let mut now_l2 = l2.clone();
        let mut carry = 0;

        while now_l1.is_some() || now_l2.is_some() || carry > 0  {
            let l1_value = match now_l1 {
                Some(node) => {
                    now_l1 = node.next;
                    node.val
                }
                None => 0
            };

            let l2_value = match now_l2 {
                Some(node) => {
                    now_l2 = node.next;
                    node.val
                }
                None => 0
            };

            let calculated = l1_value + l2_value + carry;

            let current_node = Some(Box::new(ListNode::new(calculated % 10)));

            *prev_node_next = current_node;

            match prev_node_next {
                Some(node) => {
                    prev_node_next = &mut node.next;
                }
                None => unreachable!(),
            }

            carry = calculated / 10;
        }

        ret
    }
}


#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
  }
}