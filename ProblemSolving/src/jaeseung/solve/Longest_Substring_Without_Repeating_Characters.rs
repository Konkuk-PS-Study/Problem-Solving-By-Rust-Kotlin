impl Solution {
    
    pub fn length_of_longest_substring(s: String) -> i32 {
        if s.len() == 0 {return 0};

        let mut alpha_sum: Vec<[usize; 122]> = vec!();
        alpha_sum.push([0; 122]);

        for c in s.chars() {
            let mut marking = [0; 122];
            marking = alpha_sum.last().unwrap().clone();
            marking[((c as u32) - (' ' as u32)) as usize] += 1;

            alpha_sum.push(marking);
        }

        return Self::check(&alpha_sum, 1, 1, 1) as i32;
    }

    fn check(alpha_sum: &Vec<[usize; 122]>, left: usize, right: usize, result: usize) -> usize {
        if right >= alpha_sum.len() {
            return result;
        }
        else if Self::is_dup(alpha_sum, left, right) {
            return Self::check(alpha_sum, left + 1, right, result);
        } else {
            return Self::check(alpha_sum, left, right + 1, result.max(right - left + 1));
        }
    }

    fn is_dup(alpha_sum: &Vec<[usize; 122]>, left: usize, right: usize) -> bool {
        let left_sum = alpha_sum[left - 1];
        let right_sum = alpha_sum[right];

         for i in 0..122 {
            if right_sum[i] - left_sum[i] > 1 {
                return true;
            }
        };

        return false;
    }
}